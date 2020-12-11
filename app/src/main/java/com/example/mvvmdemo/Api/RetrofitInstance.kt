package com.example.mvvmdemo.Api

import com.example.mvvmdemo.Util.Constantes.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val jsonPlaceHolderAPI : JsonPlaceHolderAPI by lazy{
        retrofit.create(JsonPlaceHolderAPI::class.java)
    }
}