package com.example.broadcasts

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.broadcasts.receiver.LogReceiver
import java.util.Timer
import java.util.TimerTask

//Broadcasts
//Broadcasts receviers
//Manifest declared broadcasts
//Context declared broadcast
//Send Broadcasts


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val send = findViewById<Button>(R.id.sendbtn)
        val input = findViewById<EditText>(R.id.input)
        send.setOnClickListener {
            val message =
                input.text.toString().takeIf { it.isNotBlank() } ?: return@setOnClickListener
            val intent = Intent()
            intent.action = "com.example.receiver.MESSAGE"
            intent.putExtra("message", message)
            sendBroadcast(intent)
        }
    }
}

