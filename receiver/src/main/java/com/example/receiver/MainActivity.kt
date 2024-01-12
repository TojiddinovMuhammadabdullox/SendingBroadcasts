package com.example.receiver

import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.receiver.ui.theme.BroadcastsTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageReceiver = MessageReceiver(::getMessages)
        val intentFilter = IntentFilter("com.example.receiver.MESSAGE")
        registerReceiver(messageReceiver, intentFilter)
        getMessages()
    }

    private fun getMessages(){
        val messages = findViewById<TextView>(R.id.messages)
        val file = File(filesDir,"message.txt")
        if (file.exists().not()){
            file.createNewFile()
        }
        messages.text = file.readText()
    }
}