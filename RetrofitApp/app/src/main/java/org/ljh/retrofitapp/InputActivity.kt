package org.ljh.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.ljh.retrofitapp.databinding.ActivityInputBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivity : AppCompatActivity() {
    lateinit var binding: ActivityInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInsert.setOnClickListener {
            var name = binding.editName.text.toString()
            var password = binding.editPassword.text.toString()
            var roles = binding.editRoles.text.toString()
            var userModel = UserModel(null, name, password, roles)
            val networkService = (applicationContext as MyApplication).netWorkService
            val result = networkService.insert(userModel)
            result.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.d("aaa", "성공")
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("aaaa","fail")
                    call.cancel()
                }
            })
            finish()
        }
    }
}