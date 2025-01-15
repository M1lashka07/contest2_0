package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ForgotPasswordBinding

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInForgot.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }

    }
}
