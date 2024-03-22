package org.ljh.viewapp01

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//
//        val name = TextView(this).apply{
//            typeface= Typeface.DEFAULT_BOLD
//            text="Lake Louise"
//        }
//        val image = ImageView(this).also {
//            it.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.lake_1))
//        }
//        val address = TextView(this).apply{
//            typeface= Typeface.DEFAULT_BOLD
//            text="Lake Louise, AB, 캐나다"
//        }
//        val layout=LinearLayout(this).apply {
//            orientation=LinearLayout.VERTICAL
//            gravity=Gravity.CENTER
//            addView(name,WRAP_CONTENT, WRAP_CONTENT)
//            addView(image,WRAP_CONTENT,WRAP_CONTENT)
//            addView(address,WRAP_CONTENT,WRAP_CONTENT)
//        }

//        setContentView(layout)
        setContentView(R.layout.layout1)
        val edNum1:EditText=findViewById(R.id.ed01)
        val edNum2:EditText=findViewById(R.id.ed02)
        val btn : Button=findViewById(R.id.btn)
        val resultTv:TextView=findViewById(R.id.tvResult)
        btn.setOnClickListener(View.OnClickListener{
            val num1 = edNum1.text.toString().toInt()
            val num2 = edNum2.text.toString().toInt()
            resultTv.text=(num1+num2).toString()
//            resultTv.setText(num1+num2)
        })

    }
}