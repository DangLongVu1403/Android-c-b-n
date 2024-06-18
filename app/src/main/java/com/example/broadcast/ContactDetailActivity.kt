package com.example.broadcast

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.broadcast.databinding.ActivityContactDetailBinding

class ContactDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")
        binding.phoneNumber.setText(phone)
        binding.name.setText(name)
        binding.username.setText(username)
        binding.pw.setText(password)
        binding.avt.setOnClickListener {
            finish()
        }
    }
}