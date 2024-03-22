package org.pgm.viewpagerapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.pgm.viewpagerapp.databinding.ActivityMainBinding
import org.pgm.viewpagerapp.databinding.ItemBinding
import org.pgm.viewpagerapp.databinding.MovieLayoutBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ids= arrayOf(R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,
            R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,
            R.drawable.mov08,R.drawable.mov09,R.drawable.mov10)

        val titles= arrayOf("써니","완득이","괴물","라디오스타","비열한거리",
            "왕의 남자","아일랜드", "웰컴투 동막골","웹보이","백투더 퓨처")

        val datas= mutableListOf<Movie>()

        for(i in 0..9){
            datas.add(Movie(titles[i], ids[i]))
        }
        binding.viewPager1.adapter=MyPagerAdapter(datas)
    }
}

class MyPagerViewHolder(val binding: MovieLayoutBinding): RecyclerView.ViewHolder(binding.root)

class MyPagerAdapter(val datas:MutableList<Movie>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyPagerViewHolder(MovieLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as MyPagerViewHolder).binding
        
        binding.tvTitle.text=datas[position].title
        binding.ivPoster.setImageResource(datas[position].posterId)
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}









