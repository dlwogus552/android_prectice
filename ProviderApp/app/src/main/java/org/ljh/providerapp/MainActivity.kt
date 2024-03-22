package org.ljh.providerapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.providerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val cursor=contentResolver.query(Uri.parse("content://org.ljh.providerapp"),
                null,null,null,null,null)
            while(cursor?.moveToNext() ?:false){
                binding.tv.append(cursor?.getString(0)?:"")

            }
        }
    }
}