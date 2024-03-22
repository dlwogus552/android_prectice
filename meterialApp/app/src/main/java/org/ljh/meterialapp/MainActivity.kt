package org.ljh.meterialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import org.ljh.meterialapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_test,menu)

        return super.onCreateOptionsMenu(menu)
    }
}