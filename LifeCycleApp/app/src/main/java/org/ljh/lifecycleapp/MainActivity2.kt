package org.ljh.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import org.ljh.lifecycleapp.databinding.ActivityMain2Binding
import org.ljh.lifecycleapp.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    var count=0
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        binding.tvCount.text=count.toString()
        Toast.makeText(this,"Main2OnCreate()", Toast.LENGTH_SHORT).show()
        binding.closeBtn.setOnClickListener{
            finish()
        }
        binding.countBtn.setOnClickListener{
            count+=1
            binding.tvCount.text=count.toString()
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
        binding.tvCount.text="$data"
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Main2OnStart()",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"Main2OnResume()",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"Main2OnPause()",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"Main2OnStop()",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"Main2OnDestroy()",Toast.LENGTH_SHORT).show()
    }
}