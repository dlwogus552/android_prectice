package org.ljh.ch17database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.ljh.ch17database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var datas:MutableList<UserInfo>? = null
    lateinit var adapter : MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        datas= mutableListOf()

        //add
        val requestLauncher:ActivityResultLauncher<Intent>
        =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val name = it.data?.getStringExtra("name").toString()
            val phone = it.data?.getStringExtra("phone").toString()
            val profile = it.data?.getStringExtra("profile").toString()
            val userInfo = UserInfo(name,phone,profile)
            adapter.notifyDataSetChanged()
        }

        binding.mainFab.setOnClickListener{
            val intent=Intent(this,AddActivity::class.java)
            requestLauncher.launch(intent)
        }
        val layoutManager=LinearLayoutManager(this)
        binding.recyclerView1.layoutManager=layoutManager
        adapter= MyAdapter(this,datas)
        binding.recyclerView1.addItemDecoration(
            DividerItemDecoration(this,LinearLayoutManager.VERTICAL)
        )
    }
}