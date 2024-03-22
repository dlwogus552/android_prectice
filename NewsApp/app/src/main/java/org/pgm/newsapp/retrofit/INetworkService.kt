package org.pgm.newsapp.retrofit

import org.pgm.newsapp.model.PageListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface INetworkService {
    @GET("/v2/everything")
    fun getList(
        @Query("q") q: String?,
        @Query("apiKey") apiKey: String?,
        @Query("page") page: Long,
        @Query("pageSize") pageSize: Int
    ): Call<PageListModel>
}