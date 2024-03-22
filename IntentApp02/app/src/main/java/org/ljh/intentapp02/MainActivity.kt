package org.ljh.intentapp02

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.intentapp02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.naver.com"))
            startActivity(intent)
        }

        binding.button2.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.77,127.41"))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
    }
}