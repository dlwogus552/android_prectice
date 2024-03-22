package org.ljh.meterialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import org.ljh.meterialapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


//        val fragmentManager=supportFragmentManager
//        val transaction = fragmentManager.beginTransaction()
//        val fragment=OneFragment()
//        transaction.add(R.id.tabContent,fragment)
//        transaction.commit() == ↓
        supportFragmentManager.beginTransaction().add(R.id.tab_content,OneFragment()).commit()


        binding.tabs.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction=supportFragmentManager.beginTransaction()
                when(tab?.text){
                    "Tab1" ->transaction.replace(R.id.tab_content,OneFragment())
                    "Tab2" ->transaction.replace(R.id.tab_content,TwoFragment())
                    "Tab3" ->transaction.replace(R.id.tab_content,ThreeFragment())
                    else->transaction.replace(R.id.tab_content,OneFragment())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}