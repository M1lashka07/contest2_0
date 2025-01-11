package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.Onboarding4Binding
import com.example.myapplication.databinding.SignUpEmptyBinding

class sign_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = SignUpEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logInTvSignup.setOnClickListener{
            val intent = Intent(this, log_in::class.java)
            startActivity(intent)
        }
    }
}

