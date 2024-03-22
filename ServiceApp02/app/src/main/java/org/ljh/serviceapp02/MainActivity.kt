package org.ljh.serviceapp02

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import org.ljh.serviceapp02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var messenger: Messenger
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.button.setOnClickListener{
            var msg = Message()
            msg.what=20
            msg.obj="hello"
            messenger.send(msg)
        }
        val intent= Intent(this,MyService::class.java)
        bindService(intent,connection, Context.BIND_AUTO_CREATE)
    }
    val connection: ServiceConnection=object :ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            messenger=Messenger(service)
        }

        override fun onServiceDisconnected(name: ComponentName?) {
        }

    }
}