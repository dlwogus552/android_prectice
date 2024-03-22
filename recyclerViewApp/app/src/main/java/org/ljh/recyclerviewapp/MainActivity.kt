package org.ljh.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.ljh.recyclerviewapp.databinding.ActivityMainBinding
import org.ljh.recyclerviewapp.databinding.ItemBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var data = mutableListOf<String>()
        for(i in 1..20) {
            data.add("item $i")
        }
//        val layoutManager=LinearLayoutManager(this)
//        layoutManager.orientation=LinearLayoutManager.HORIZONTAL
        val layoutManager=GridLayoutManager(this,2)
        binding.recyclerview1.layoutManager=layoutManager
        binding.recyclerview1.adapter=MyAdapter(data)
        binding.recyclerview1.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

    }
}


class MyViewHolder(val binding: ItemBinding):RecyclerView.ViewHolder(binding.root)

class MyAdapter(val data:MutableList<String>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewHolder).binding
        binding.itemData.text=data[position]
    }
}