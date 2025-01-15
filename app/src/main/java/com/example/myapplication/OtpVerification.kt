package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.OtpVerificationBinding

class OtpVerification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = OtpVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}