package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.OtpVerificationBinding

class OtpVerification : AppCompatActivity() {

    private lateinit var first : EditText
    private lateinit var second : EditText
    private lateinit var third : EditText
    private lateinit var fourth : EditText
    private lateinit var fifth : EditText
    private lateinit var sixth : EditText
    private lateinit var button: Button

    private val textWatcher = object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            changeButtonState()
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private fun changeButtonState(){
        val isAllField = isAllField()
        button.setBackgroundResource(if (isAllField) R.drawable.shape_button_full else R.drawable.shape_button_empty)
        button.isEnabled = isAllField
    }

    private fun isAllField(): Boolean{
        val first1 = first.text.toString().isNotEmpty()
        val second1 = second.text.toString().isNotEmpty()
        val third1 = third.text.toString().isNotEmpty()
        val fourth1 = fourth.text.toString().isNotEmpty()
        val fifth1 = fifth.text.toString().isNotEmpty()
        val sixth1 = sixth.text.toString().isNotEmpty()
        return first1 && second1 && third1 && fourth1 && fifth1 && sixth1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = OtpVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        first = binding.et1Otp
        second = binding.et2Otp
        third = binding.et3Otp
        fourth = binding.et4Otp
        fifth = binding.et5Otp
        sixth = binding.et6Otp
        button = binding.buttonOTPVerif

        val fields = listOf(first, second, third, fourth, fifth, sixth)
        fields.forEach {
            it.addTextChangedListener(textWatcher)
        }

        button.setOnClickListener {
            val intent = Intent(this, NewPassword::class.java)
            startActivity(intent)
        }
    }
}