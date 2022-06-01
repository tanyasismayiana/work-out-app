package dev.tanya.homeworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var etEmail:TextInputEditText
        lateinit var etPassword:TextInputEditText
        lateinit var tilEmail:TextInputLayout
        lateinit var tilPassword:TextInputLayout
        lateinit var btnLogin:Button
        lateinit var tvSignUp:TextView
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


    }
    fun validateLogin(){
        var email = etEmail.text.toString()
        var password= etPassword.text.toString()

        if (email.isBlank()) {
            tilEmail.error = "@string/errorEmail"
        }

    }



