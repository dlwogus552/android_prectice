package org.ljh.resourceapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import org.ljh.resourceapp01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
//        var binding=.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setTextColor(ResourcesCompat.getColor(resources,R.color.blue, null))


    }
}