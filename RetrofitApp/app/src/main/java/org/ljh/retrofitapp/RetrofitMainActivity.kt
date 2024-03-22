package org.ljh.retrofitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.ljh.retrofitapp.databinding.ActivityRetrofitMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityRetrofitMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRetrofitMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener{
            val intent= Intent(this,InputActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val networkService=(applicationContext as MyApplication).netWorkService
        val userListCall=networkService.doGetUserList()
        userListCall.enqueue(object : Callback<UserListModel>{
            override fun onResponse(call: Call<UserListModel>,
                                    response: Response<UserListModel>) {
                if(response.isSuccessful){
                    binding.recyclerView1.layoutManager=LinearLayoutManager(this@RetrofitMainActivity)
                    val userList=response.body()?.users
                    Log.d("users","${userList}")
                    val adapter=MyAdapter(this@RetrofitMainActivity,userList)
                    binding.recyclerView1.adapter=adapter
                    binding.recyclerView1.addItemDecoration(
                        DividerItemDecoration(this@RetrofitMainActivity,LinearLayoutManager.VERTICAL)
                    )
                }
            }
            override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                call.cancel()
            }
        })
    }
}