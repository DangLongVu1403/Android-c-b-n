package com.example.broadcast

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class map : AppCompatActivity() {
    private lateinit var editTextAddress: EditText
    private lateinit var buttonOpenMap: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_map)

        // Initialize UI elements
        editTextAddress = findViewById(R.id.editTextAddress)
        buttonOpenMap = findViewById(R.id.buttonOpenMap)

        // Set click listener for the button
        buttonOpenMap.setOnClickListener {
            val address = editTextAddress.text.toString().trim()
            if (address.isNotEmpty()) {
                openMapWithAddress(address)
            } else {
                // Show a message if the address field is empty
                Toast.makeText(this, "Vui lòng nhập địa chỉ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openMapWithAddress(address: String) {
        val uri = Uri.parse("geo:0,0?q=${Uri.encode(address)}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            // Show a message if there is no application to handle the intent
            Toast.makeText(this, "Không tìm thấy ứng dụng để mở bản đồ", Toast.LENGTH_SHORT).show()
        }
    }
}