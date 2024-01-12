package com.example.broadcasts.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class LogReceiver(private val onLogReceived:(message: String)->Unit) : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
        val message = intent.getStringExtra("message") ?: return
        onLogReceived(message)
    }
}