package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ReceiveReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action == "com.example.START_SERVICE_OR_ACTIVITY") {
            Toast.makeText(context, "Broadcast received in App2", Toast.LENGTH_SHORT).show()

            // Khởi động Activity hoặc Service tùy theo yêu cầu của bạn
            val activityIntent = Intent(context, ListContact::class.java)
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(activityIntent)

            // Hoặc khởi động Service
            // val serviceIntent = Intent(context, MyService::class.java)
            // context.startService(serviceIntent)
        }
    }
}