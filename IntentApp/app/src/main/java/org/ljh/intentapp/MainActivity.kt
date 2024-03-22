package org.ljh.intentapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import org.ljh.intentapp.databinding.ActivityMainBinding
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {
    var age: Int=0
    lateinit var name: String
    lateinit var phone: String

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            age = it.data?.getIntExtra("age",0).toString().toInt()
            name = it.data?.getStringExtra("name").toString()
            phone = it.data?.getStringExtra("phone").toString()
        }
        binding.input.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            requestLauncher.launch(intent)
        }
        binding.output.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("age", age)
            intent.putExtra("name", name)
            intent.putExtra("phone", phone)
            startActivity(intent)
        }
//        binding.button.setOnClickListener{
//            val intent: Intent=Intent(this,DetailActivity::class.java)
//            val num1 = binding.editTextText.text.toString().toInt()
//            val num2 = binding.editTextText2.text.toString().toInt()
//            intent.putExtra("num1",num1)
//            intent.putExtra("num2",num2)
//            requestLauncher.launch(intent)
//        }

//        binding.button.setOnClickListener{
////            DetailActivity()
//            val intent: Intent=Intent(applicationContext,DetailActivity::class.java)
//            startActivity(intent)
//        }
    }

}