package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class onboarding_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.onboarding_1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.onboarding_1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<android.widget.Button>(R.id.skip_onb_1).setOnClickListener {
            var intent = Intent(this, holder::class.java)
            startActivity(intent)
        }

        findViewById<android.widget.Button>(R.id.next_onb_1).setOnClickListener {
            var intent = Intent(this, onboarding_4::class.java)
            startActivity(intent)
        }
    }
}