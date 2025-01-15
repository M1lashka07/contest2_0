package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Onboarding1Binding

class Onboarding1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = Onboarding1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.skipOnb1.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        binding.nextOnb1.setOnClickListener {
            val intent = Intent(this, Onboarding4::class.java)
            startActivity(intent)
        }
    }
}