package org.ljh.eventapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import org.ljh.eventapp01.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    var initTime=0L;
    var pauseTime=0L;

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding= ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.startBtn.setOnClickListener{
            binding.chronometer1.base=SystemClock.elapsedRealtime()+pauseTime
            binding.chronometer1.start()
            binding.stopBtn.isEnabled=true
            binding.resetBtn.isEnabled=true
            binding.startBtn.isEnabled=false
        }
        binding.stopBtn.setOnClickListener{
            pauseTime=binding.chronometer1.base-SystemClock.elapsedRealtime()
            binding.chronometer1.stop()
            binding.stopBtn.isEnabled=false
            binding.resetBtn.isEnabled=true
            binding.startBtn.isEnabled=true
        }
        binding.resetBtn.setOnClickListener{
            pauseTime=0L
            binding.chronometer1.base=SystemClock.elapsedRealtime()
            binding.stopBtn.isEnabled=false
            binding.resetBtn.isEnabled=true
            binding.startBtn.isEnabled=true
        }
    }
}