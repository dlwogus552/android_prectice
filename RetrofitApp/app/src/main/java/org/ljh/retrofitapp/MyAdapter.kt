package org.ljh.retrofitapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import org.ljh.retrofitapp.databinding.ItemBinding

class MyViewHolder(val binding:ItemBinding):RecyclerView.ViewHolder(binding.root)

class MyAdapter(val context:Context, val datas:List<UserModel>?):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return datas?.size ?:0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewHolder).binding
        val user=datas?.get(position)
        binding.userName.text=user?.username
        binding.userName.setOnClickListener{
            val intent= Intent(context,DetailActivity::class.java)
            intent.putExtra("id",user?.id)
            intent.putExtra("username",user?.username)
            context.startActivity(intent)
        }
    }

}