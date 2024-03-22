package org.ljh.ch11app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.ljh.ch11app.databinding.ItemBinding

class MyViewHolder(val binding:ItemBinding):RecyclerView.ViewHolder(binding.root)
class MyAdapter(val context: Context, val datas:MutableList<Todo>?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return datas?.size ?:0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding =(holder as MyViewHolder).binding
        binding.textView.text= datas!![position].title
        binding.root.setOnClickListener{
            val intent=Intent(context,ViewActivity::class.java)
            intent.putExtra("title",datas!![position].title)
            intent.putExtra("content",datas!![position].content)
            context.startActivity(intent)
        }
    }
}