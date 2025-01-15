package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.NewPasswordBinding

class NewPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = NewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}