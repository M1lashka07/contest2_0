package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class onboarding_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.onboarding_4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.onboarding_4)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<android.widget.Button>(R.id.skip_onb_4).setOnClickListener {
            var intent = Intent(this, holder::class.java)
            startActivity(intent)
        }

        findViewById<android.widget.Button>(R.id.next_onb_4).setOnClickListener {
            var intent = Intent(this, onboarding_3::class.java)
            startActivity(intent)
        }

    }
}