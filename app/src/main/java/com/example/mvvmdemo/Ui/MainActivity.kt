package com.example.mvvmdemo.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.Adapter.PostAdapter
import com.example.mvvmdemo.R
import com.example.mvvmdemo.ViewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
    private val postAdapter by lazy { PostAdapter(this) }
    private lateinit var recyclerViewMain : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewMain = findViewById(R.id.recyclerViewMain)
        observerPosts()
    }

    private fun observerPosts(){
        Log.i("TESTE", "Entrou")
        mainViewModel.getPosts().observe(this, Observer {
            if (it != null){
                postAdapter.setPosts(it)
                recyclerViewMain.adapter = postAdapter
            }


        })
    }
}