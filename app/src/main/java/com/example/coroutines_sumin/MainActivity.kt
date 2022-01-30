package com.example.coroutines_sumin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.coroutines_sumin.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            lifecycleScope.launchWhenResumed {
                loadData()
            }
        }
    }

    private suspend fun loadData() {
        binding.progressBar.isVisible = true
        binding.button.isEnabled = false
        val city = loadCity()
        binding.location.text = city
        val temperature = loadTemperature()
        binding.temperature.text = temperature.toString()
        binding.progressBar.isVisible = false
        binding.button.isEnabled = true
    }

    private suspend fun loadCity(): String {
        delay(5000)
        return "Moscow"
    }

    private suspend fun loadTemperature(): Int {
        delay(1000)
        return 17
    }
}