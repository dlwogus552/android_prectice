package org.ljh.zpackapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import org.ljh.zpackapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu2, menu)
        val menuItem=menu?.findItem(R.id.menu3)
        val searchView=menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.tv1.setText(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                binding.tv1.setText(newText)
                return true
            }

        })
        return super.onCreateOptionsMenu(menu)
    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu2, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.menu1 -> {
//                binding.tv1.setText(item.title)
//                true
//            }
//            R.id.menu2 -> {
//                binding.tv1.setText(item.title)
//                true
//            }
//            R.id.menu3 -> {
//                binding.tv1.setText(item.title)
//                true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val menuItem1:MenuItem?=menu?.add(0,0,0,"menu1")
//        val menuItem2:MenuItem?=menu?.add(0,1,0,"menu2")
//        val menuItem3:MenuItem?=menu?.add(0,2,0,"menu3")
//
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            0 -> {
//                binding.tv1.setTextColor(Color.GREEN)
//                binding.tv1.setText(item.title)
//                true
//            }
//            1 -> {
//                binding.tv1.setTextColor(Color.RED)
//                binding.tv1.setText("menu2")
//                true
//            }
//            2 -> {
//                binding.tv1.setTextColor(Color.BLUE)
//                binding.tv1.setText(item.title)

//                true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
}