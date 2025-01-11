package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ForgotPasswordBinding
import com.example.myapplication.databinding.LogInEmptyBinding

class forgot_password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInForgot.setOnClickListener {
            val intent = Intent(this, log_in::class.java)
            startActivity(intent)
        }

    }
}
