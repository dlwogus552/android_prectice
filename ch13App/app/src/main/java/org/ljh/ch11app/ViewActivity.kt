package org.ljh.ch11app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.ch11app.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding=ActivityViewBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.title.text=intent.getStringExtra("title")
        binding.content.text=intent.getStringExtra("content")

        binding.button.setOnClickListener{
            finish()
        }
    }
}