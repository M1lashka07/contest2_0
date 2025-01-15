package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.Onboarding4Binding

class Onboarding4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Onboarding4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.skipOnb4.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        binding.nextOnb4.setOnClickListener {
            val intent = Intent(this, Onboarding3::class.java)
            startActivity(intent)
        }

    }
}