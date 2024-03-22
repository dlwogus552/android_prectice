package org.ljh.broadcastapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.ljh.broadcastapp.databinding.ActivityMain2Binding
import java.util.Objects

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        registerReceiver(receiver, filter)
    }
    val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                Intent.ACTION_SCREEN_ON -> Log.d("aaa", "screen on")
                Intent.ACTION_SCREEN_OFF -> Log.d("aaa", "screen off")

                Intent.ACTION_BATTERY_CHANGED->Log.d("aaa", "Changed")
                Intent.ACTION_BATTERY_LOW->Log.d("aaa", "Low")
                Intent.ACTION_BATTERY_OKAY->Log.d("aaa", "Okay")
                Intent.ACTION_POWER_CONNECTED->Log.d("aaa", "Connected")
                Intent.ACTION_POWER_DISCONNECTED->Log.d("aaa", "Disconnected")
            }
        }
    }
    val filter = IntentFilter().apply {
        addAction(Intent.ACTION_SCREEN_ON)
        addAction(Intent.ACTION_SCREEN_OFF)
        addAction(Intent.ACTION_BATTERY_OKAY)
        addAction(Intent.ACTION_POWER_CONNECTED)
        addAction(Intent.ACTION_POWER_DISCONNECTED)
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}