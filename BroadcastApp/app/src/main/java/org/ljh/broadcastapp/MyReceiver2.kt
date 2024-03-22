package org.ljh.broadcastapp

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MyReceiver2 : BroadcastReceiver() {

    @SuppressLint("NotificationPermission")
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.d("aaa","MyReceiver2")
        val manager=context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        val builder : NotificationCompat.Builder

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){//26버전
            val channelId="one-Channel"
            val channelName="My Channel One"
            val channel=NotificationChannel(channelId,channelName,NotificationManager.IMPORTANCE_DEFAULT).apply {
                description="My Channel One Description"
                setShowBadge(true)
                val uri:Uri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri,audioAttributes)
                enableVibration(true)
            }
            manager.createNotificationChannel(channel)
            builder=NotificationCompat.Builder(context,channelId)
        }else{
            builder=NotificationCompat.Builder(context)
        }
        builder.run {
            setSmallIcon(android.R.drawable.ic_notification_overlay)
            setWhen(System.currentTimeMillis())
            setContentTitle("홍길동")
            setContentText("안녕")
        }
        manager.notify(11,builder.build())
    }
}