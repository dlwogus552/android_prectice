package org.pgm.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pgm.newsapp.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    lateinit var binding : ActivityNewsBinding
    lateinit var volleyFragment : VolleyFragment
    lateinit var retrofitFragment: RetrofitFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitFragment=RetrofitFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.container1,retrofitFragment)
            .commit()
    }
}