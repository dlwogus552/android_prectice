package org.ljh.lifecycleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import org.ljh.lifecycleapp.databinding.ActivityMain2Binding
import org.ljh.lifecycleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var count=0
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Toast.makeText(this,"OnCreate()",Toast.LENGTH_SHORT).show()

        binding.main2Btn.setOnClickListener{
            val intent= Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        binding.countBtn2.setOnClickListener{
            count+=1
            binding.tvCount2.text=count.toString()
        }
    }
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        val data = savedInstanceState?.getInt("count")
        binding.tvCount2.text="$data"
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"OnStart()",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"OnResume()",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"OnPause()",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"OnStop()",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"OnDestroy()",Toast.LENGTH_SHORT).show()
    }
}