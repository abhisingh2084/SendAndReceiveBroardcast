package com.abhishek.sendandreceivebroardcast

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    lateinit var broadcastSend:Button

    private var BROADCAST_SEND = "com.abhishek.sendandreceivebroardcast.BROADCAST_SEND"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        broadcastSend=findViewById(R.id.broadcast_send)


        broadcastSend.setOnClickListener{
            val intent= Intent()

            intent.action=BROADCAST_SEND

            sendBroadcast(intent)

        }

    }
}