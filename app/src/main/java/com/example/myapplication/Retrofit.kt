package com.example.myapplication

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofit {
    private const val BASE_URL = "https://mrxkqjnchchqgarfcwtb.supabase.co"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userAPI: UserAPI = retrofit.create(UserAPI::class.java)
}