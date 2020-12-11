package com.example.mvvmdemo.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.Model.Post
import com.example.mvvmdemo.Repositorie.PostRepository

class MainViewModel : ViewModel() {
    private var posts = MutableLiveData<MutableList<Post>>()

    fun  getPosts() : LiveData<MutableList<Post>>{
        PostRepository.getAllPosts().observeForever {
            posts.value = it

        }
        return posts
    }

}