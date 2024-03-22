package org.ljh.drawerapp01.ui.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is example Fragment"
    }
    val text: LiveData<String> = _text
}