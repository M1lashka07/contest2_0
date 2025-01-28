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
import androidx.lifecycle.lifecycleScope

import com.example.myapplication.databinding.SignUpEmptyBinding
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch
import java.security.MessageDigest

class SignUp : AppCompatActivity() {

    private lateinit var name : EditText  //Создаём переменные для всех объектов, имеющих действие
    private lateinit var phone : EditText
    private lateinit var email : EditText
    private lateinit var pass : EditText
    private lateinit var confPass : EditText
    private lateinit var policy : CheckBox
    private lateinit var hintPass : ImageButton
    private lateinit var hintConfPass : ImageButton
    private lateinit var signUpButton : Button
    private lateinit var toLogIn : TextView
    private lateinit var supabaseClient : SupabaseClient
    private var isPasswordVisible = false
    private var isConfPasswordVisible = false

    private val textWatcher = object : TextWatcher {             //Метод, отслеживающий ввод текста в строку
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            updateButtonState()
        }
        override fun afterTextChanged(s: Editable?) {}
    }

    private fun updateButtonState() {                       // Метод для изменения цвета кнопки и включения её для использования
        val isFormValid = isFormValid ()

        signUpButton.setBackgroundResource(if (isFormValid) R.drawable.shape_button_full else R.drawable.shape_button_empty)
        signUpButton.isEnabled = isFormValid
    }

    private fun isFormValid(): Boolean{   // Метод возвращающий значения true при обнаружении информации в поле
        val name1 = name.text.toString().isNotEmpty()
        val phone1 = phone.text.toString().isNotEmpty()
        val email1 = isEmailValid(email.text.toString())
        val pass1 = pass.text.toString().isNotEmpty()
        val confPass1 = confPass.text.toString() == pass.text.toString()
        val policy1 = policy.isChecked
        return name1 && phone1 && email1 && pass1 && confPass1 && policy1
    }

    private fun isEmailValid(email : String): Boolean{  // Метод проверки Email на соответствие патерну
        val emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.ru$"
        return email.matches(emailPattern.toRegex())
    }

    private fun togglePasswordVisibility() {
        isPasswordVisible = !isPasswordVisible

        if (isPasswordVisible) {
            pass.inputType = 1
        } else {
            pass.inputType = 129 }
        pass.setSelection(pass.text.length)}

    private fun toggleConfPasswordVisibility() {
        isConfPasswordVisible = !isConfPasswordVisible

        if (isConfPasswordVisible) {
            confPass.inputType = 1

        } else {
            confPass.inputType = 129
        }
        confPass.setSelection(confPass.text.length)}

    private fun hashPassword(password : String): String {
        val digest = MessageDigest.getInstance("SHA-512")
        val hashedBytes = digest.digest(password.toByteArray())
        return hashedBytes.joinToString("") {
            String.format("%02x", it)}
    }

    override fun onCreate(savedInstanceState: Bundle?) {     // Хэшируем пароль
        super.onCreate(savedInstanceState)
        val binding = SignUpEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = binding.etSignupFlname  //Инициализируем переменные
        phone = binding.etSignupPhone
        email = binding.etSignupEmail
        pass = binding.etSignupPass
        confPass = binding.etSignupConfpass
        policy = binding.cbSignupPolicy
        hintPass = binding.hintPassSignUp
        hintConfPass = binding.hintConfirmPassSignUp
        signUpButton = binding.signUpButton
        toLogIn = binding.logInTvSignup

        pass.inputType = 129
        confPass.inputType = 129

        supabaseClient = createSupabaseClient(
            supabaseUrl = "https://mrxkqjnchchqgarfcwtb.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im1yeGtxam5jaGNocWdhcmZjd3RiIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzczNzg0ODYsImV4cCI6MjA1Mjk1NDQ4Nn0.Pzh0P8CfiNuREUIsJwjytFCXwMlhOSZI7lPNuJQVgck"){
            install(Postgrest)
        }

        suspend fun createUserInSupabase(name : String, phone : String, email: String, password: String){
            val userData = mapOf(
                "name" to name,
                "phone" to phone,
                "email" to email,
                "password" to password,)
            supabaseClient.from("User").insert(userData)
        }

        fun onRegisterButtonClick(){
            val hashedPassword = hashPassword(password = pass.text.toString())
            lifecycleScope.launch {
                createUserInSupabase(name = name.text.toString(), phone = phone.text.toString(), email = email.text.toString(), password = hashedPassword)
            }
        }

        val fields = listOf(name, phone, email, pass, confPass, policy)

        fields.forEach { field ->
            when (field) {
                is EditText -> field.addTextChangedListener(textWatcher)
                is CheckBox -> field.setOnCheckedChangeListener { _, _ -> updateButtonState() }
            }
        }

        hintPass.setOnClickListener{
            togglePasswordVisibility()
        }

        hintConfPass.setOnClickListener{
            toggleConfPasswordVisibility()
        }

        signUpButton.setOnClickListener {
            onRegisterButtonClick()
            val intent = Intent (this, LogIn::class.java)
            startActivity(intent)
        }

        toLogIn.setOnClickListener{
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
    }
}




