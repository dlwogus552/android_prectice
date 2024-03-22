package org.ljh.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.inputmethod.InputMethodManager
import org.ljh.lifecycleapp.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding=ActivityMain3Binding.inflate(layoutInflater)
        val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            binding.editTextText.requestFocus()
            manager.showSoftInput(binding.editTextText,InputMethodManager.SHOW_IMPLICIT)
        }
        binding.button2.setOnClickListener{
            binding.editTextText.requestFocus()
            manager.hideSoftInputFromWindow(currentFocus?.windowToken,InputMethodManager.HIDE_IMPLICIT_ONLY)
        }
        binding.button3.setOnClickListener{
            binding.editTextText.requestFocus()
            manager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,InputMethodManager.HIDE_IMPLICIT_ONLY)
        }
    }
}