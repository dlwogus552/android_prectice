package org.ljh.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.intentapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val age = intent.getIntExtra("age",0)
        val name = intent.getStringExtra("name")
        val phone= intent.getStringExtra("phone")
        binding.age.setText("나이 : $age")
        binding.name.setText("이름 : $name")
        binding.phone.setText("번호 : $phone")

//        binding.closeBtn.setOnClickListener{
//            val sum =num1 +num2
//            intent.putExtra("result",sum)
//            setResult(RESULT_OK, intent)
//            finish()
//        }
        binding.closeBtn.setOnClickListener{
            finish()
        }
    }
}