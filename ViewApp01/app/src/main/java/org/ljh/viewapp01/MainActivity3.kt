package org.ljh.viewapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val btn1: Button=findViewById(R.id.btnShow)
        val btn2:Button=findViewById(R.id.btnHide)
        val image:ImageView = findViewById(R.id.iV)

        btn1.setOnClickListener(View.OnClickListener {
            image.visibility=View.VISIBLE
        })
        btn2.setOnClickListener(View.OnClickListener {
            image.visibility=View.GONE
        })
    }

}