package org.ljh.fragmentapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.ljh.fragmentapp01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val fragmenManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmenManager.beginTransaction()
        val fragment = OneFragment()
        transaction.add(R.id.fragment_container, fragment)
        transaction.commit()
        binding.button.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)

//        binding.button2.setOnClickListener {
//            val fragmenManager: FragmentManager = supportFragmentManager
//            val transaction: FragmentTransaction = fragmenManager.beginTransaction()
//            val fragment = TwoFragment()
//            transaction.replace(R.id.fragment_container, fragment)
//            transaction.addToBackStack(null)
//            transaction.commit()
//
//        }
    }

    override fun onClick(v: View?) {
        val fragmenManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmenManager.beginTransaction()
        lateinit var fragment: Fragment
        when (v?.id) {
            R.id.button -> fragment = OneFragment()
            R.id.button2 -> fragment = TwoFragment()
            R.id.button3 -> fragment = ThreeFragment()
        }
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}