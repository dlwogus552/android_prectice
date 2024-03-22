package org.ljh.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import org.ljh.firebaseapp.databinding.ActivityMainBinding
import org.ljh.firebaseapp.util.myCheckPermission

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myCheckPermission(this)
        binding.addFab.setOnClickListener {
            if (MyApplication.checkAuth()) {
                var intent = Intent(this, AddActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"인증을 진행해주세요",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (MyApplication.checkAuth()) {
            binding.logoutTextView.visibility = View.GONE
            binding.mainRecyclerView.visibility = View.VISIBLE
            makeRecyclerView()
        } else {
            binding.logoutTextView.visibility = View.VISIBLE
            binding.mainRecyclerView.visibility = View.GONE
        }
    }

    private fun makeRecyclerView() {
        MyApplication.db.collection("news")
            .get()
            .addOnSuccessListener {result ->
                val itemList = mutableListOf<ItemData>()
                for(document in result){
                    val item=document.toObject(ItemData::class.java)
                    item.docId=document.id
                    itemList.add(item)
                }
                binding.mainRecyclerView.layoutManager=LinearLayoutManager(this)
                binding.mainRecyclerView.adapter=MyAdapter(this,itemList)
            }
            .addOnFailureListener {
                Log.d("aaaa","error..getting document",it)
                Toast.makeText(this,"데이터 읽기 실패",Toast.LENGTH_SHORT).show()
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        startActivity(Intent(this, AuthActivity::class.java))
        return super.onOptionsItemSelected(item)
    }
}