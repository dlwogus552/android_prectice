package org.ljh.permissionapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import org.ljh.permissionapp.databinding.ActivityMainBinding
import org.ljh.permissionapp.databinding.DialogLayoutBinding

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button5.setOnClickListener{
            val dialogBinding=DialogLayoutBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("input")
                setView(dialogBinding.root)
                dialogBinding.radioButton.setOnClickListener{
                    var name = dialogBinding.editTextText.text.toString()
                    binding.tv1.setText("이름:$name, 남자")
                }
                dialogBinding.radioButton2.setOnClickListener{
                    var name = dialogBinding.editTextText.text.toString()
                    binding.tv1.setText("이름:$name, 여자")
                }
                setPositiveButton("닫기",null)
                show()
            }
        }



        binding.button2.setOnClickListener {
            DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    binding.tv1.setText("data:$year, $month, $dayOfMonth")
                }
            }, 2024, 1, 16).show()
        }
        binding.button3.setOnClickListener {
            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    binding.tv1.setText("time:$hourOfDay:$minute")
                }
            }, 0, 0, true).show()
        }

        //multi check
//        binding.button4.setOnClickListener {
//            val items = arrayOf("사과", "복숭아", "포도")
//            AlertDialog.Builder(this).run {
//                setTitle("item test")
//                setIcon(android.R.drawable.ic_dialog_alert)
//                setMultiChoiceItems(items,
//                    booleanArrayOf(true, false, false),
//                    object : DialogInterface.OnMultiChoiceClickListener {
//                        override fun onClick(
//                            dialog: DialogInterface?,
//                            which: Int,
//                            isChecked: Boolean
//                        ) {
//                            if (isChecked){
//                                binding.tv1.setText("${items[which]}이 선택")
//                            }else{
//                                binding.tv1.setText("${items[which]}이 해제")
//                            }
//                        }
//                    }
//                )
//                setPositiveButton("닫기",null)
//                show()
//            }
//        }
        //single check
        binding.button4.setOnClickListener{
            val items = arrayOf("사과", "복숭아", "포도")
            AlertDialog.Builder(this).run {
                setTitle("items")
                setIcon(android.R.drawable.sym_def_app_icon)
                setSingleChoiceItems(items,1,object :DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        binding.tv1.setText("${items[which]}이(가) 선택")
                    }
                })
                setPositiveButton("닫기", null)
                show()
            }
        }

        binding.button.setOnClickListener {
            val toast = Toast.makeText(this, "토스트 테스트", Toast.LENGTH_SHORT)
            toast.addCallback(
                object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        binding.tv1.setText("Toast Hidden")
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        binding.tv1.setText("Toast Show")
                    }
                }
            )
            toast.show()
        }


        val requestLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGreanted ->
            if (isGreanted) {
                Log.d("aaa", "callback...grented")
            } else {
                Log.d("aaa", "callback...denied")
            }

        }
        val status = ContextCompat.checkSelfPermission(
            this,
            "android.permission.ACCESS_FINE_LOCATION"
        )
        if (status == PackageManager.PERMISSION_GRANTED) {
            Log.d("aaa", "granted")
        } else {
            requestLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
        }
    }
}