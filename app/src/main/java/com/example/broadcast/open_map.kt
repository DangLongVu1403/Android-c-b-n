package com.example.broadcast

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class open_map : AppCompatActivity() {
    private lateinit var editTextAddress: EditText
    private lateinit var buttonOpenMap: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_open_map)
        editTextAddress = findViewById(R.id.editTextAddress)
        buttonOpenMap = findViewById(R.id.buttonOpenMap)

        buttonOpenMap.setOnClickListener {
            val address = editTextAddress.text.toString()
            if (address.isNotEmpty()) {
                openMapWithAddress(address)
            }
        }
    }
    private fun openMapWithAddress(address: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("geo:0,0?q=${Uri.encode(address)}")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}