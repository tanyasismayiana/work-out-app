package dev.tanya.homeworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
        lateinit var etEmail: TextInputEditText
        lateinit var etPassword: TextInputEditText
        lateinit var tilEmail:TextInputLayout
        lateinit var tilPassword:TextInputLayout
        lateinit var btnLogin:Button
        lateinit var tvSignUp:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        tilPassword=findViewById(R.id.tilPassword)
        tilEmail=findViewById(R.id.tilEmail)
        btnLogin=findViewById(R.id.btnLogin)
        tvSignUp=findViewById(R.id.tvSignUp)

        tvSignUp.setOnClickListener {
            var intent=Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            validateLogin()

        }
    }
    fun validateLogin(){
        var email =etEmail.text.toString()
        var password=etPassword.text.toString()

        etEmail.

        if (email.isBlank()) {
            tilEmail.error = "@string/errorEmail"
        }
        if (patterns.EMAIL_ADDRESS.matcher(email).matches()){
            tilEmail.error = "Email is invalid"
        }
        if (password.isBlank()){
            tilPassword.error="password is required"
        }

        if (confirmpassword ! = password){
            tillPassword.error ="password not matched"
        }



    }

    }




