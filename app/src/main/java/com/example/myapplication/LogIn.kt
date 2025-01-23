package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LogInEmptyBinding

class LogIn : AppCompatActivity() {

    private lateinit var email : EditText
    private lateinit var pass : EditText
    private lateinit var savePass : CheckBox
    private lateinit var button : Button
    private lateinit var toForgotPass : TextView
    private lateinit var toSignUp : TextView
    private lateinit var hintPass : ImageButton
    private var isPasswordVisible = false

    private val textWatcher = object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            changeButton()
        }
    }

    private fun changeButton(){
        val isAllValid = isAllValid()

        button.setBackgroundResource(if (isAllValid) R.drawable.shape_button_full else R.drawable.shape_button_empty)
        button.isEnabled = isAllValid
    }

    private fun isAllValid(): Boolean{
        val email1 = isEmailValid(email.text.toString())
        val pass1 = pass.text.toString().isNotEmpty()
        return email1 && pass1
    }

    private fun isEmailValid( email : String ): Boolean{
        val emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.ru$"
        return email.matches(emailPattern.toRegex())
    }

    private fun togglePassVisible(){
        isPasswordVisible = !isPasswordVisible

        if (isPasswordVisible){
            pass.inputType = 1
        }
        else {
            pass.inputType = 129
        }
        pass.setSelection(pass.text.length)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LogInEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = binding.emailLogIn
        pass = binding.passLogIn
        savePass = binding.cbLogIn
        button = binding.buttonLogIn
        toForgotPass = binding.forgotLogin
        toSignUp = binding.signUpLogin
        hintPass = binding.hintPassLogIn

        val fields = listOf(email, pass, savePass)

        fields.forEach {
            when(it){
                is EditText -> it.addTextChangedListener(textWatcher)
            }
        }

        pass.inputType = 129

        hintPass.setOnClickListener {
            togglePassVisible()
        }

        button.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        toForgotPass.setOnClickListener{
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        toSignUp.setOnClickListener {
           val intent = Intent(this, SignUp::class.java)
           startActivity(intent)
        }
    }
}