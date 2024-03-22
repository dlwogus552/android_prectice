package org.pgm.viewpagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import org.pgm.viewpagerapp.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMain4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        toggle=ActionBarDrawerToggle(this,binding.drawer1,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
            }
        return super.onOptionsItemSelected(item)
    }
}