package org.ljh.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import org.ljh.firebaseapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var docId=intent.getStringExtra("docId").toString()
        MyApplication.db.collection("news")
            .document(docId)
            .get()
            .addOnSuccessListener {
                var data= it.toObject(ItemData::class.java)
                binding.detailEmailView.text=data?.email
                binding.detailContentView.text=data?.content
                binding.detailDateView.text=data?.date
                data?.docId=docId

                val imgRef=MyApplication.storage.reference.child("image/${data?.docId}.jpg")
                imgRef.downloadUrl.addOnCompleteListener{task->
                    if(task.isSuccessful){
                        Glide.with(this)
                            .load(task.result)
                            .into(binding.detailImageView)
                    }
                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}