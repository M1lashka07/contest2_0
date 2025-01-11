package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.Onboarding4Binding

class onboarding_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Onboarding4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.skipOnb4.setOnClickListener {
            val intent = Intent(this, sign_up::class.java)
            startActivity(intent)
        }

        binding.nextOnb4.setOnClickListener {
            val intent = Intent(this, onboarding_3::class.java)
            startActivity(intent)
        }

    }
}