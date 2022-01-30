package com.example.coroutines_sumin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.view.isVisible
import com.example.coroutines_sumin.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            loadData()
        }
    }

    private fun loadData() {
        binding.progressBar.isVisible = true
        binding.button.isEnabled = false
        loadCity {
            binding.location.text = it
            loadTemperature {
                binding.temperature.text = it.toString()
                binding.progressBar.isVisible = false
                binding.button.isEnabled = true
            }
        }
    }

    private fun loadCity(callback: (String) -> Unit) {
        thread {
            Thread.sleep(5000)
            handler.post {
                callback.invoke("Moscow")
            }
        }
    }

    private fun loadTemperature(callback: (Int) -> Unit) {
        thread {
            Thread.sleep(1000)
            handler.post {
                callback.invoke(17)
            }
        }
    }
}