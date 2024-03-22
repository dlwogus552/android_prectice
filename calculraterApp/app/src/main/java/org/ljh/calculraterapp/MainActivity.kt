package org.ljh.calculraterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import org.ljh.calculraterapp.databinding.ActivityMainBinding
import java.util.StringTokenizer

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var btns:Array<Button>
    var str1=""
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        btns= arrayOf(findViewById(R.id.btn0),findViewById(R.id.btn1),findViewById(R.id.btn2),
            findViewById(R.id.btn3),findViewById(R.id.btn4),findViewById(R.id.btn5),findViewById(R.id.btn6),
            findViewById(R.id.btn7),findViewById(R.id.btn8),findViewById(R.id.btn9),findViewById(R.id.btnAdd),
            findViewById(R.id.btnSub),findViewById(R.id.btnDiv),findViewById(R.id.btnMul),findViewById(R.id.btnDot))
        binding.btnResult.setOnClickListener{
            var dim ="+-*/"
            val str= StringTokenizer(str1,dim,true)
            val num1 : Double=str.nextToken().toDouble()
            val op=str.nextToken()
            val num2 : Double=str.nextToken().toDouble()
            when(op){
                "+" ->binding.tvResult.setText("${num1+num2}")
                "-" ->binding.tvResult.setText("${num1-num2}")
                "*" ->binding.tvResult.setText("${num1*num2}")
                "/" ->binding.tvResult.setText("${num1/num2}")
            }
            binding.prevCal.setText(str1)
            str1=binding.tvResult.text.toString()
        }
        for(b in btns){
            b.setOnClickListener{
                str1+=b.text.toString()
                binding.tvResult.text=str1
            }
        }


    }
}