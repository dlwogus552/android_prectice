package org.ljh.databaseapp02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.databaseapp02.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding= ActivityMain4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnNewGet.setOnClickListener{
            val newSharedPref=getSharedPreferences("my_pref", Context.MODE_PRIVATE)

            var data3= newSharedPref.getString("data3","a")
            var data4=newSharedPref.getInt("data4",0)

            binding.tvResult2.text="$data3, $data4"
        }
    }
}