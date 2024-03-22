package org.ljh.retrofitapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface INetworkService {
    @GET("home")
    fun doHome():Call<String>

    @GET("list")
    fun doGetUserList(): Call<UserListModel>

    @GET("getUser/{id}")
    fun doGetUserId(@Path("id") id: Long): Call<UserModel>

    @GET("getUsername/{username}")
    fun doGetUsername(@Path("username") username: String): Call<UserModel>

    @POST("insert")
    fun insert(@Body user: UserModel): Call<String>
}