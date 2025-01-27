package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserAPI {
    @POST("public.Users")
    fun registerUser(@Body request: User): Call<Void>
}