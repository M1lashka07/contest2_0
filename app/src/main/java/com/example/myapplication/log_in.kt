package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.LogInEmptyBinding
import com.example.myapplication.databinding.Onboarding4Binding

class log_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LogInEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.forgotLogin.setOnClickListener{
            val intent = Intent(this, forgot_password::class.java)
            startActivity(intent)
        }

        binding.signUpLogin.setOnClickListener {
            val intent = Intent(this, sign_up::class.java)
            startActivity(intent)
        }
    }
}