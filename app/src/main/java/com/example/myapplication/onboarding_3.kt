package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.Onboarding3Binding
import com.example.myapplication.databinding.Onboarding4Binding

class onboarding_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Onboarding3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpOnb3.setOnClickListener {
            val intent = Intent(this, sign_up::class.java)
            startActivity(intent)
        }

        binding.signInOnb3.setOnClickListener {
            val intent = Intent(this, log_in::class.java)
            startActivity(intent)
        }
    }
}