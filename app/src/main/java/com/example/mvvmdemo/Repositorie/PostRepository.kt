package com.example.mvvmdemo.Repositorie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo.Api.RetrofitInstance
import com.example.mvvmdemo.Model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PostRepository{

    private val data = MutableLiveData<MutableList<Post>>()
    fun getAllPosts() : MutableLiveData<MutableList<Post>>{
        RetrofitInstance.jsonPlaceHolderAPI.getPosts().enqueue(object : Callback<MutableList<Post>>{
            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                Log.i("TESTE","${t.localizedMessage}")
                data.value = null
            }

            override fun onResponse(call: Call<MutableList<Post>>, response: Response<MutableList<Post>>) {
                data.postValue(response.body())
            }

        })


        return data
    }





}