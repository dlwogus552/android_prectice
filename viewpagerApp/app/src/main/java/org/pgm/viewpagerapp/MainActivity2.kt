package org.pgm.viewpagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.pgm.viewpagerapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewPager2.adapter=MyFragmentAdapter(this)
    }
}


class MyFragmentAdapter(activity: FragmentActivity):FragmentStateAdapter(activity) {
    val fragments:List<Fragment>
    init {
        fragments=listOf(OneFragment(),TwoFragment(),ThreeFragment())
    }
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}