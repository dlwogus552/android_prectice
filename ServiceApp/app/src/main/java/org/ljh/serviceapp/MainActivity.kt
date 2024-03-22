package org.ljh.serviceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.serviceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.root.setOnClickListener{
            val intent= Intent(this,MyService::class.java)
            startService(intent)
        }

        binding.button.setOnClickListener{
            val intent= Intent(this,MyService::class.java)
            stopService(intent)
        }
    }
}