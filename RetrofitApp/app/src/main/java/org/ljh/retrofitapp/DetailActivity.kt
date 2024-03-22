package org.ljh.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.retrofitapp.databinding.ActivityDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding=ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val id = intent.getLongExtra("id",0)
        val username=intent.getStringExtra("username")
        val networkService=(applicationContext as MyApplication).netWorkService
        val userModelCall=networkService.doGetUserId(id)
        userModelCall.enqueue(object : Callback<UserModel>{
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                val userModel=response.body()
                binding.tvUser.text="ID : ${userModel?.id},User Name : ${userModel?.username},Password : ${userModel?.password},Role : ${userModel?.roles}"
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                call.cancel()
            }
        })
    }
}