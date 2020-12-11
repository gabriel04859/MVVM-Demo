package com.example.mvvmdemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.Model.Post
import com.example.mvvmdemo.R
import de.hdodenhof.circleimageview.CircleImageView

class PostAdapter(private val context : Context) : RecyclerView.Adapter<PostAdapter.CharacterViewHolder>() {
    private var postList : MutableList<Post> = ArrayList()
    fun setPosts(posts : MutableList<Post>){
        postList = posts

    }

    inner class CharacterViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textViewUserId = itemView.findViewById<TextView>(R.id.textViewUserId)
        val textViewId = itemView.findViewById<TextView>(R.id.textViewId)
        val textViewTitle = itemView.findViewById<TextView>(R.id.textViewTitle)
        val textViewBody = itemView.findViewById<TextView>(R.id.textViewBody)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return CharacterViewHolder(view)


    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val post = postList[position]
        post.apply {
            holder.textViewUserId.text = userId.toString()
            holder.textViewId.text = id.toString()
            holder.textViewTitle.text = title
            holder.textViewBody.text = body
        }

    }
}