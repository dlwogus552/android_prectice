package org.ljh.galleryapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.galleryapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnMap.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:35.1795543,129.0756416"))
            startActivity(intent)
        }
        binding.btnCall.setOnClickListener{
            val intent = Intent(Intent.ACTION_CALL)
            startActivity(intent)
        }
        binding.button3.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.naver.com"))
            startActivity(intent)
        }
    }
}