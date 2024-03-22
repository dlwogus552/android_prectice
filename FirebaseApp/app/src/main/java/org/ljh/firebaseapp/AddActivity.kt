package org.ljh.firebaseapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.ljh.firebaseapp.databinding.ActivityAddBinding
import org.ljh.firebaseapp.util.dateToString
import java.io.File
import java.time.LocalDateTime
import java.util.Date

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    lateinit var filePath:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add,menu)
        return super.onCreateOptionsMenu(menu)
    }

    val requestLauncher=registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode===android.app.Activity.RESULT_OK){
            Glide
                .with(getApplicationContext())
                .load(it.data?.data)
                .apply(RequestOptions().override(250,200))
                .centerCrop()
                .into(binding.addImageView)

            val cursor=contentResolver.query(it.data?.data as Uri,
                arrayOf<String>(MediaStore.Images.Media.DATA),null,null,null)
            cursor?.moveToFirst().let {
                filePath=cursor?.getString(0) as String
                Log.d("aaaa","$filePath")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_add_gallery ->{
                var intent= Intent(Intent.ACTION_PICK)
                intent.setDataAndType(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    "image/*"
                )
                requestLauncher.launch(intent)
            }
            R.id.menu_add_save ->{
                if(binding.addImageView.drawable !==null && binding.addEditView.text.isNotBlank()){
                    saveStore()
                }else{
                    Log.d("aaa","데이터 입력 없음")
                }
            }

        }
        return super.onOptionsItemSelected(item)
    }

    fun saveStore(){
        val data = mapOf(
            "email" to MyApplication.email,
            "content" to binding.addEditView.text.toString(),
            "date" to dateToString(Date()))
        MyApplication.db.collection("news")
            .add(data)
            .addOnSuccessListener {
                uploadImage(it.id)
            }
            .addOnFailureListener{
                Log.d("aaa","이미지 업로드 실패")
            }
    }
    fun uploadImage(docId:String){
        val storage=MyApplication.storage
        val storageRef=storage.reference
        val imgRef = storageRef.child("image/${docId}.jpg")
        val file = Uri.fromFile(File(filePath))
        imgRef.putFile(file)
            .addOnSuccessListener {
                Toast.makeText(this,"save ok...",Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Log.d("kkang","file save error",it)
            }
    }
}