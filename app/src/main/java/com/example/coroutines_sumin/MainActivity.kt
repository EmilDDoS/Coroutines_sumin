package com.example.coroutines_sumin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.coroutines_sumin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            loadData()
        }
    }

    private fun loadData() {
        binding.progressBar.isVisible = true
        binding.button.isEnabled = false
        val city = loadCity()
        binding.location.text = city
        val temperature = loadTemperature()
        binding.temperature.text = temperature.toString()
        binding.progressBar.isVisible = false
        binding.button.isEnabled = true
    }

    private fun loadCity(): String {
        Thread.sleep(5000)
        return "Moscow"
    }

    private fun loadTemperature(): Int {
        Thread.sleep(1000)
        return 17
    }
}