package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.LogInEmptyBinding
import com.example.myapplication.databinding.OtpVerificationBinding

class otp_verification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = OtpVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}