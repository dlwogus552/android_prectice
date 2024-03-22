package org.ljh.ch11app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.ljh.ch11app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var datas:MutableList<Todo>? = null
    lateinit var adapter : MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        datas= mutableListOf()

        //add
        val requestLauncher:ActivityResultLauncher<Intent>
        =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val title = it.data?.getStringExtra("title")
            val content = it.data?.getStringExtra("content")
            val todo = Todo(title.toString(), content.toString())
            datas?.add(todo)
            adapter.notifyDataSetChanged()
//            it.data!!.getStringExtra("result")?.let{
//                datas?.add(it)
//                adapter.notifyDataSetChanged()
//            }
        }
        binding.mainFab.setOnClickListener{
            val intent=Intent(this, AddActivity::class.java)
            requestLauncher.launch(intent)
        }

        val layoutManager=LinearLayoutManager(this)
        binding.recyclerView1.layoutManager=layoutManager
        adapter=MyAdapter(this,datas)
        binding.recyclerView1.adapter=adapter
        binding.recyclerView1.addItemDecoration(
            DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
    }
}