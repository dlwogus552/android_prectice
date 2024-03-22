package org.ljh.firebaseapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.ljh.firebaseapp.databinding.ItemMainBinding

class MyViewHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter (val context:Context, val itemList:MutableList<ItemData>):RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(ItemMainBinding.inflate(layoutInflater))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = itemList.get(position)
        holder.binding.run{
            itemEmailText.text="${data.docId}, ${data.email}"
            itemDateView.text=data.date
            itemContentView.text=data.content
        }
        val imgRef=MyApplication.storage.reference.child("image/${data.docId}.jpg")
        imgRef.downloadUrl.addOnCompleteListener{task->
            if(task.isSuccessful){
                Glide.with(context)
                    .load(task.result)
                    .into(holder.binding.itemImageView)
            }
        }
        holder.binding.root.setOnClickListener{
            val intent= Intent(context,DetailActivity::class.java)
            intent.putExtra("docId",data.docId)
            context.startActivity(intent)
        }
    }
}