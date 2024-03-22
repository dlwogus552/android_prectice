package org.ljh.serviceapp

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService2 : Service() {
    class MyBinder : Binder(){
        fun funA(arg : Int){
            Log.d("aaa","funA.....$arg")
        }
        fun funB(arg : Int):Int{
            Log.d("aaa","funB.....$arg")
            return arg * arg
        }
    }
    override fun onBind(intent: Intent): IBinder {
        return MyBinder()
    }
}