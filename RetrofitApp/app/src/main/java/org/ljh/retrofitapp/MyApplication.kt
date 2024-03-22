package org.ljh.retrofitapp

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    var netWorkService:INetworkService
    val retrofit:Retrofit
        get()=Retrofit.Builder()
            .baseUrl("http://10.100.105.168:8082/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    init {
        netWorkService=retrofit.create(INetworkService::class.java)
    }
}