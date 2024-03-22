package org.ljh.menuapp01

import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import org.ljh.menuapp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        registerForContextMenu(binding.imageView3)
        binding.imageView3.layoutParams.width=100
        binding.imageView3.layoutParams.height=100
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val layoutParams = binding.imageView3.layoutParams
        Log.d("aaa","${layoutParams.width}")
        Log.d("aaa","${layoutParams.height}")
        when (item.itemId) {
            R.id.up -> {
                if (layoutParams.width*2 < 500) {
                    layoutParams.width *=2
                    layoutParams.height *=2
                    binding.imageView3.layoutParams=layoutParams
                }else{
                    layoutParams.width = 500
                    layoutParams.height = 500
                    binding.imageView3.layoutParams=layoutParams
                }
            }

            R.id.down -> {
                if (layoutParams.width * 0.5 > 50) {
                    layoutParams.width = (layoutParams.width*0.5).toInt()
                    layoutParams.height = (layoutParams.height*0.5).toInt()
                    binding.imageView3.layoutParams=layoutParams
                }else{
                    layoutParams.width = 50
                    layoutParams.height = 50
                    binding.imageView3.layoutParams=layoutParams
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu?.setHeaderTitle("Rotation")
        menuInflater.inflate(R.menu.menu2, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var rotation: Float = binding.imageView3.rotation
        when (item.itemId) {
            R.id.right -> {
                binding.imageView3.rotation = rotation + 15F
            }

            R.id.left -> {
                binding.imageView3.rotation = rotation - 15F
            }
        }
        return super.onContextItemSelected(item)
    }

}