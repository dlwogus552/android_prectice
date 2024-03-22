package org.ljh.networkapp

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneStateListener
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import org.ljh.networkapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var telephonyManager: TelephonyManager
    lateinit var binding: ActivityMainBinding
    private fun callChanged() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            telephonyManager.registerTelephonyCallback(
                mainExecutor,
                object : TelephonyCallback(), TelephonyCallback.CallStateListener {
                    override fun onCallStateChanged(p0: Int) {
                        when (p0) {
                            TelephonyManager.CALL_STATE_IDLE -> {
                                Log.d("kkang", "idle.....")
                                binding.tv.text = "idle"
                            }

                            TelephonyManager.CALL_STATE_OFFHOOK -> {
                                Log.d("kkang", "offhook...")
                                binding.tv.text = "offhook"
                            }

                            TelephonyManager.CALL_STATE_RINGING -> {
                                Log.d("kkang", "ringing...")
                                binding.tv.text = "ringing"
                            }
                        }
                    }
                }
            )
        } else {
            val listener = object : PhoneStateListener() {
                override fun onCallStateChanged(state: Int, phoneNumber: String?) {
                    when (state) {
                        TelephonyManager.CALL_STATE_IDLE -> {
                            Log.d("kkang", "idle.....")
                            binding.tv.text = "idle"
                        }

                        TelephonyManager.CALL_STATE_OFFHOOK -> {
                            Log.d("kkang", "offhook...")
                            binding.tv.text = "offhook"
                        }

                        TelephonyManager.CALL_STATE_RINGING -> {
                            Log.d("kkang", "ringing...")
                            binding.tv.text = "ringing"
                        }
                    }
                }
            }
            telephonyManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE)
        }
    }

    @SuppressLint("MissingPermission")
    private fun phoneInfo() {
        val countryIso = telephonyManager.networkCountryIso
        val operatorName = telephonyManager.networkOperatorName
        val phoneNumber = telephonyManager.line1Number

        Log.d("kkang", "$countryIso, $operatorName, $phoneNumber")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            if (it.all { permission -> permission.value == true }) {
                callChanged()
                phoneInfo()
            } else {
                Toast.makeText(this, "permission denied...", Toast.LENGTH_SHORT).show()
            }
        }

        if (ContextCompat.checkSelfPermission(
                this,
                "android.permission.READ_PHONE_NUMBERS"
            ) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(
                this,
                "android.permission.READ_PHONE_STATE"
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            callChanged()
            phoneInfo()
        } else {
            permissionLauncher.launch(
                arrayOf(
                    "android.permission.READ_PHONE_NUMBERS",
                    "android.permission.READ_PHONE_STATE"
                )
            )
        }
    }
}