package org.ljh.newsapp01

import android.app.Application
import org.ljh.newsapp01.retrofit.INetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {
    companion object {
        val QUERY = "travel"
        val API_KEY = "079dac74a5f94ebdb990ecf61c8854b7"
        val BASE_URL = "https://newsapi.org"
        val USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"

        var networkService: INetworkService
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        init {
            networkService = retrofit.create(INetworkService::class.java)
        }
    }
}







