package org.ljh.broadcastapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.broadcastapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            val intent= Intent(this, MyReceiver::class.java)
            sendBroadcast(intent)
        }

    }
}