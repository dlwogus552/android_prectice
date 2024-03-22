package org.ljh.databaseapp02

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.databaseapp02.databinding.ActivityMain3Binding
import org.ljh.databaseapp02.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMain3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val pref=getPreferences(Context.MODE_PRIVATE)
        val sharedPref=getSharedPreferences("my_pref",Context.MODE_PRIVATE)//shared는 공유가능
        binding.put.setOnClickListener{
            pref.edit().run{
                putString("data1","hello")
                putInt("data2",10)
                commit()
            }
            sharedPref.edit().run{
                putString("data3","world")
                putInt("data4",20)
                commit()
            }
        }
        binding.get.setOnClickListener{
            val data1=pref.getString("data1","aaaaa")
            val data2=pref.getInt("data2",0)
            val data3=sharedPref.getString("data3","aaaaa")
            val data4=sharedPref.getInt("data4",0)
            binding.tvResult.text="$data1, $data2, $data3, $data4"

        }

        binding.btnNew.setOnClickListener{
            val intent= Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }
    }
}