package com.example.mvvmdemo.Api

import com.example.mvvmdemo.Model.Post
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderAPI {
    @GET("posts")
    fun getPosts() : Call<MutableList<Post>>
}