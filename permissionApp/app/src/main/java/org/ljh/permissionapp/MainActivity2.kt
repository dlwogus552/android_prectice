package org.ljh.permissionapp

import android.annotation.SuppressLint
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import org.ljh.permissionapp.databinding.ActivityMain2Binding
import org.ljh.permissionapp.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding= ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button6.setOnClickListener{
            val uri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone=RingtoneManager.getRingtone(applicationContext,uri)
            ringtone.play()
        }

        binding.button7.setOnClickListener{
            val vibrator=if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                val manager=getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                manager.defaultVibrator
            }else{
                getSystemService(VIBRATOR_MANAGER_SERVICE) as Vibrator
            }
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                vibrator.vibrate(
                    VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE)
                )
            }else{
                vibrator.vibrate(500)
            }
        }

    }
}