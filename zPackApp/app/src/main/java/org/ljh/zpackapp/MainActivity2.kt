package org.ljh.zpackapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import org.ljh.zpackapp.databinding.ActivityMain2Binding
import org.ljh.zpackapp.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        registerForContextMenu(binding.button2)
        registerForContextMenu(binding.button3)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu3, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        when(v?.id){
            R.id.button2->{
                menu?.setHeaderTitle("button1 menu")
                menuInflater.inflate(R.menu.button_menu1,menu)
            }
            R.id.button3->{
                menu?.setHeaderTitle("button2 menu")
                menuInflater.inflate(R.menu.button_menu2,menu)
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.size20->{
                binding.tv.setTextSize(20F)
                true
            }
            R.id.size30->{
                binding.tv.setTextSize(30F)
                true
            }
            R.id.red->{
                binding.tv.setTextColor(Color.RED)
                true
            }
            R.id.green->{
                binding.tv.setTextColor(Color.GREEN)
                true
            }
            R.id.blue->{
                binding.tv.setTextColor(Color.BLUE)
                true
            }
        }
        return super.onContextItemSelected(item)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.size20->{
                binding.tv.setTextSize(20F)
                true
            }
            R.id.size30->{
                binding.tv.setTextSize(30F)
                true
            }
            R.id.size40->{
                binding.tv.setTextSize(40F)
                true
            }
            R.id.red->{
                binding.tv.setTextColor(Color.RED)
                true
            }
            R.id.green->{
                binding.tv.setTextColor(Color.GREEN)
                true
            }
            R.id.blue->{
                binding.tv.setTextColor(Color.BLUE)
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}