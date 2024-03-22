package org.ljh.newsapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import org.ljh.newsapp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDraw.setOnClickListener{
            Glide.with(this)
                .load(R.drawable.abc)
                .override(500,500)
                .into(binding.imageView)
        }
        binding.btnUrl.setOnClickListener{
            val url="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDAxMTVfMjcw%2FMDAxNzA1MzAzNzkxOTMx.DEB8vgqLeGqQFsbOFnRQ2FxARb4t-gkVM0Zt137H2Qwg.go5eWVa5Zmykeezy5d18o-f3ROBEiQPFf-zXY5q7wlYg.JPEG.goood5678%2F78.jpg&type=sc960_832"
            Glide.with(this)
                .load(url)
                .override(500,500)
                .into(binding.imageView)
        }
    }
}