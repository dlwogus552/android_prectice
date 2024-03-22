package org.ljh.intentapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.intentapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.butGoogle.setOnClickListener{
            val intent= Intent()
            intent.action="ACTION_EDIT"
            intent.data= Uri.parse("http://www.google.com")
            startActivity(intent)
        }

    }
}