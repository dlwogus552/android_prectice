package org.ljh.broadcastapp

import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ljh.broadcastapp.databinding.ActivityMain3Binding
import org.ljh.broadcastapp.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMain3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))!!.apply {
            when (getIntExtra(BatteryManager.EXTRA_STATUS, -1)) {
                BatteryManager.BATTERY_STATUS_CHARGING -> {
                    when (getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)) {
                        BatteryManager.BATTERY_PLUGGED_USB -> {
//                            binding.imageView.setImageResource(R.drawable.usb)
                            binding.imageView.setImageBitmap(
                                BitmapFactory.decodeResource(
                                    resources, R.drawable.usb
                                )
                            )
                            binding.chargingResult.text = "USB Plugged"
                        }

                        BatteryManager.BATTERY_PLUGGED_AC -> {
//                            binding.imageView.setImageResource(R.drawable.usb)
                            binding.imageView.setImageBitmap(
                                BitmapFactory.decodeResource(
                                    resources, R.drawable.ac
                                )
                            )
                            binding.chargingResult.text = "AC Plugged"
                        }
                    }
                }

                else -> {
                    binding.chargingResult.text = "Not Plugged"
                    binding.imageView.setImageResource(0)

                }
            }
            val level = getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val scale = getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPercent = level / scale.toFloat() * 100
            binding.percentResult.text = "$batteryPercent"
        }
        binding.runBtn.setOnClickListener{
            val intent= Intent(this, MyReceiver2::class.java)
            sendBroadcast(intent)
        }
    }

}