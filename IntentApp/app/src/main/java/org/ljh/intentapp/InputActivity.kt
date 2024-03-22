package org.ljh.intentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.intentapp.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityInputBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.button3.setOnClickListener {
            val age = binding.editAge.text.toString().toInt()
            val name = binding.editName.text.toString()
            val phone = binding.editPhone.text.toString()
            intent.putExtra("age",age)
            intent.putExtra("name",name)
            intent.putExtra("phone",phone)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}