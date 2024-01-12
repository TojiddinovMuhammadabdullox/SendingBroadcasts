package com.example.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import java.io.File

class MessageReceiver(private val onMessageReceived:()-> Unit) :BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        val message = intent!!.getStringExtra("message")?: return
        val file = File(context.filesDir, "message.txt")
        if (file.exists().not()){
            file.createNewFile()
        }
        file.appendText(message + "\n")
        onMessageReceived()
    }
}