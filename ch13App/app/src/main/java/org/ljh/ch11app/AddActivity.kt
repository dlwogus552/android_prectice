package org.ljh.ch11app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import org.ljh.ch11app.databinding.ActivityAddBinding
import org.ljh.ch11app.databinding.ItemBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_save_add ->{
                val intent=intent
                intent.putExtra("title",binding.addTitle.text.toString())
                intent.putExtra("content",binding.addContent.text.toString())
                setResult(RESULT_OK,intent)
                finish()
                true
            }
            else -> true
        }
        return true
    }
}