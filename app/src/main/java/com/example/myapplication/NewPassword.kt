package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.NewPasswordBinding

class NewPassword : AppCompatActivity() {

    private lateinit var pass : EditText
    private lateinit var confPass : EditText
    private lateinit var hintPass : ImageButton
    private lateinit var hintConfPass : ImageButton
    private lateinit var button : Button
    private var passVisible = false
    private var confPassVisible = false

    private val textWatcher = object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            changeButtonState()
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private fun togglePass(){
        passVisible = !passVisible

        if (passVisible){
            pass.inputType = 1
        } else {
            pass.inputType = 129
        }
        pass.setSelection(pass.text.length)
    }

    private fun toggleConfPass(){
        confPassVisible = !confPassVisible

        if (confPassVisible){
            confPass.inputType = 1
        }else {
            confPass.inputType = 129
        }
        confPass.setSelection(confPass.text.length)
    }

    private fun changeButtonState(){
        val isAllField = isAllField()
        button.setBackgroundResource(if (isAllField) R.drawable.shape_button_full else R.drawable.shape_button_empty)
        button.isEnabled = isAllField
    }

    private fun isAllField(): Boolean{
        val pass1 = pass.text.toString().isNotEmpty()
        val confPass1 = confPass.text.toString() == pass.text.toString()
        return pass1 && confPass1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = NewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pass = binding.passNewPass
        confPass = binding.confPassNewPass
        hintPass = binding.hintPassNewPass
        hintConfPass = binding.hintConfirmPassNewPass
        button = binding.buttonNewPass

        pass.inputType = 129
        confPass.inputType = 129

        val fields = listOf(pass, confPass)

        fields.forEach {
            it.addTextChangedListener(textWatcher)
        }

        hintPass.setOnClickListener {
            togglePass()
        }

        hintConfPass.setOnClickListener {
            toggleConfPass()
        }

        button.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}