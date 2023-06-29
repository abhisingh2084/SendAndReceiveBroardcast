package com.abhishek.sendandreceivebroardcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var sendSecond:Button
    lateinit var broadcastText:TextView

    private var BROADCAST_SEND = "com.abhishek.sendandreceivebroardcast.BROADCAST_SEND"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendSecond=findViewById(R.id.send_second)

        broadcastText=findViewById(R.id.broadcast_text)

        registerBroadcast(this)

        sendSecond.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)

            startActivity(intent)


        }

    }



    private fun registerBroadcast(context: Context){

        val filter = IntentFilter(BROADCAST_SEND)

        context?.registerReceiver(broadcastReceiver(),filter)
    }

    inner class broadcastReceiver(): BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {

            Toast.makeText(applicationContext, "RECEIVED", Toast.LENGTH_SHORT).show()

            broadcastText.text="RECEIVED"
        }


    }
}