package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.Onboarding1Binding
import com.example.myapplication.databinding.Onboarding4Binding

class onboarding_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = Onboarding1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.skipOnb1.setOnClickListener {
            val intent = Intent(this, sign_up::class.java)
            startActivity(intent)
        }

        binding.nextOnb1.setOnClickListener {
            val intent = Intent(this, onboarding_4::class.java)
            startActivity(intent)
        }
    }
}