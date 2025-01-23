package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ForgotPasswordBinding

class ForgotPassword : AppCompatActivity() {

    private lateinit var email : EditText
    private lateinit var button : Button
    private lateinit var toLogIn : TextView

    private val textWatcher = object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            changeButtonState()
        }
    }

    private fun isEmailValid(email : String): Boolean{
        val pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.ru"
        return email.matches(pattern.toRegex())
    }

    private fun changeButtonState(){
        button.setBackgroundResource(if (isEmailValid(email.text.toString())) R.drawable.shape_button_full else R.drawable.shape_button_empty)
        button.isEnabled = isEmailValid(email.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = binding.emailForgotPass
        button = binding.buttonSendOTP
        toLogIn = binding.signInForgot

        email.addTextChangedListener(textWatcher)

        button.setOnClickListener {
            val intent = Intent(this, OtpVerification::class.java)
            startActivity(intent)
        }

        toLogIn.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
    }
}
