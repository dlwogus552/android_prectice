package org.ljh.eventapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import org.ljh.eventapp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btn1.setOnClickListener(MyEventHandler(binding))
        binding.btn2.setOnClickListener(MyEventHandler(binding))
        binding.btn3.setOnClickListener(MyEventHandler(binding))

//        binding.btn1.setOnClickListener(this)
//        binding.btn2.setOnClickListener(this)
//        binding.btn3.setOnClickListener(this)


//        binding.btn1.setOnClickListener(View.OnClickListener {
//            binding.textView2.setText("버튼 1 누름")
//        })
//        binding.btn2.setOnClickListener(View.OnClickListener {
//            binding.textView2.setText("버튼 2 누름")
//        })
//        binding.btn3.setOnClickListener(View.OnClickListener {
//            binding.textView2.setText("버튼 3 누름")
//        })//기본적인 이벤트 리스너 방법

        binding.btn1.setOnLongClickListener {
            binding.textView2.setText("버튼1 longClicked")
            true
        }
    }
//
//    fun onClicked(view: View?){
//        when(view?.id){
//            R.id.btn1->binding.textView2.setText("버튼 1 누름")
//            R.id.btn2->binding.textView2.setText("버튼 2 누름")
//            R.id.btn3->binding.textView2.setText("버튼 3 누름")
//        }
//    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("bbbb","onKeyDown")
        binding.tvResult.setText("onKeyDown")
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode){
            KeyEvent.KEYCODE_0 -> binding.tvResult.setText("0누름")
            KeyEvent.KEYCODE_1 -> binding.tvResult.setText("1누름")
            KeyEvent.KEYCODE_A -> binding.tvResult.setText("a누름")
            KeyEvent.KEYCODE_DPAD_UP -> binding.tvResult.setText("↑누름")
            KeyEvent.KEYCODE_DPAD_DOWN -> binding.tvResult.setText("↓누름")
        }
        return super.onKeyUp(keyCode, event)
    }


    override fun onTouchEvent(event:MotionEvent?):Boolean{
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                Log.d("aaaa","Touch down x:${event.x},y:${event.y} rawX:${event.rawX}, rawY:${event.rawY}")
                binding.tvResult.setText("Touch down")
            }
            MotionEvent.ACTION_UP->{
                binding.tvResult.setText("Touch Up")
                Log.d("aaaa","Touch up x:${event.x},y:${event.y}")
            }
            MotionEvent.ACTION_MOVE->{
                binding.tvResult.setText("Touch Move")
                Log.d("aaaa","Touch move event x:${event.x},y:${event.y}")
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn1->binding.textView2.setText("버튼 1 누름")
            R.id.btn2->binding.textView2.setText("버튼 2 누름")
            R.id.btn3->binding.textView2.setText("버튼 3 누름")
        }
    }
}
class MyEventHandler(val binding: ActivityMainBinding):View.OnClickListener{
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn1->binding.textView2.setText("버튼 1 누름")
            R.id.btn2->binding.textView2.setText("버튼 2 누름")
            R.id.btn3->binding.textView2.setText("버튼 3 누름")
        }

    }

}