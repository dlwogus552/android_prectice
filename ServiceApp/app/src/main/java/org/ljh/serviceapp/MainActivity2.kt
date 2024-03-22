package org.ljh.serviceapp

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import org.ljh.serviceapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var serviceBinder:MyService2.MyBinder
    val connection=object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            serviceBinder=service as MyService2.MyBinder
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent= Intent(this, MyService2::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
        binding.funA.setOnClickListener{
            serviceBinder.funA(10)
        }
        binding.funB.setOnClickListener{
            var a = serviceBinder.funB(10)
            Log.d("aaa","$a")
            binding.text.text=a.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }
}