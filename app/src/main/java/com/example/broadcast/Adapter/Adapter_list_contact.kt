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

class Adapter_list_contact(var Contact: MutableList<Taikhoan>, val recyclerViewHandle: RecyclerViewOnClick): RecyclerView.Adapter<Adapter_list_contact.listcontact>() {
    inner class listcontact(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listcontact {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return listcontact(view)
    }

    override fun onBindViewHolder(holder: listcontact, position: Int) {
        holder.itemView.apply {
            var Name = findViewById<TextView>(R.id.name)
            var PhoneNumber = findViewById<TextView>(R.id.phoneNumber)
            var avatarContact = findViewById<ImageView>(R.id.avt)
            Name.setText(Contact[position].hoTen)
            PhoneNumber.setText((Contact[position].soDienThoai))
            holder.itemView.setOnClickListener {
                recyclerViewHandle.onClickItem(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return Contact.size
    }
}