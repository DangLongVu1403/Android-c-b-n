package com.example.broadcast.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.broadcast.R
import com.example.broadcast.Taikhoan
import com.example.broadcast.`interface`.RecyclerViewOnClick
import com.example.broadcast.music

class Adapter_list_music(var music: MutableList<music>, val recyclerViewHandle: RecyclerViewOnClick): RecyclerView.Adapter<Adapter_list_music.listcontact>() {
    inner class listcontact(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listcontact {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music,parent,false)
        return listcontact(view)
    }

    override fun onBindViewHolder(holder: listcontact, position: Int) {
        holder.itemView.apply {
            var NameSong = findViewById<TextView>(R.id.nameSong)
            var Author = findViewById<TextView>(R.id.author)
            NameSong.setText(music[position].nameSong)
            Author.setText((music[position].author))
            holder.itemView.setOnClickListener {
                recyclerViewHandle.onClickItem(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return music.size
    }
}