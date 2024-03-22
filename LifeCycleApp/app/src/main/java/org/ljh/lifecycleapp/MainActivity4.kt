package org.ljh.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import org.ljh.lifecycleapp.databinding.ActivityMain4Binding
import kotlin.system.measureNanoTime

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            val channel = Channel<Int>()
            var sum = 0L

            val scope = CoroutineScope(Dispatchers.Default + Job())
            scope.launch {
                var time = measureNanoTime {
                    for (i in 1..2_000_000_000) {
                        sum += i
                    }
                }
                channel.send(sum.toInt())
            }
            val mainScope=GlobalScope.launch(Dispatchers.Main) {
                channel.consumeEach {
                    binding.textView.text = "$sum"

                }
            }
        }
    }
}