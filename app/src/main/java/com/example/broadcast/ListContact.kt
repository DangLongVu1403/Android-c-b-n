package com.example.broadcast

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.broadcast.Adapter.Adapter_list_contact
import com.example.broadcast.databinding.ActivityListContactBinding
import com.example.broadcast.`interface`.RecyclerViewOnClick

class ListContact : AppCompatActivity() {
    private lateinit var binding: ActivityListContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ds = mutableListOf<Taikhoan>()
        ds.add(Taikhoan("Long Vũ","0326590404","LongVu","123456"))
        ds.add(Taikhoan("Phan Tuấn","0981197564","Phan Tuan","12345"))
        ds.add(Taikhoan("a","0123","a","123"))
        ds.add(Taikhoan("v","01234","b","1"))
        ds.add(Taikhoan("c","12345","c","c"))
        val adapter = Adapter_list_contact(ds,object : RecyclerViewOnClick {
            override fun onClickItem(pos: Int){
                val taikhoan = ds[pos]
                val intent = Intent(this@ListContact, ContactDetailActivity::class.java )
                intent.putExtra("name", taikhoan.hoTen)
                intent.putExtra("phone", taikhoan.soDienThoai)
                intent.putExtra("username", taikhoan.userName)
                intent.putExtra("password", taikhoan.passWord)
                startActivity(intent)
            }
        })
        val listHistory = binding.rvContact
        listHistory.adapter = adapter
        listHistory.layoutManager = LinearLayoutManager(this)
        listHistory.setHasFixedSize(true)
    }
}