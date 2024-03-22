package org.pgm.recyclerviewapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.pgm.recyclerviewapp01.databinding.ActivityMain2Binding
import org.pgm.recyclerviewapp01.databinding.ItemLayoutBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val rids= arrayOf(R.drawable.img,R.drawable.person,R.drawable.img,R.drawable.img,R.drawable.person)
        val names= arrayOf("홍길동","권유미","최수열","강소희","김도형")
        val phones= arrayOf("010-2222-1231","010-2222-1224","010-2222-1234","010-2222-1234","010-2222-1235")
        var data= mutableListOf<Person>()
        for(i in 0..4){
            data.add(Person(names[i], phones[i], rids[i]))
        }
        binding.recyclerview2.layoutManager=LinearLayoutManager(this)
        binding.recyclerview2.adapter=MyAdapter2(data, binding)
        binding.recyclerview2.addItemDecoration(DividerItemDecoration(this,
            LinearLayoutManager.VERTICAL))
    }
}

class MyViewHolder2(val binding:ItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

class MyAdapter2(val data:MutableList<Person>, val abinding:ActivityMain2Binding):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder2(ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyViewHolder2).binding
//        if(position%2==0){
//            binding.imageView.setImageResource(R.drawable.img)
//        }else{
//            binding.imageView.setImageResource(R.drawable.person)
//        }
        binding.imageView.setImageResource(data[position].rid)
        binding.tvName.text=data[position].name
        binding.tvPhone.text=data[position].phone

        binding.root.setOnClickListener{
            abinding.tvResult.text="name:${data[position].name}, phone:${data[position].phone}"
        }
    }

}







