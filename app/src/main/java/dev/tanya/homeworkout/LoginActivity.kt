package dev.tanya.homeworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.tanya.homeworkout.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSignUp.setOnClickListener {
            var intent=Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            validateLogin()

        }
    }
    fun validateLogin(){
        var email =binding.etEmail.text.toString()
        var password=binding.etPassword.text.toString()
        var error=false


        if (email.isBlank()) {
            binding.tilEmail.error = "@string/errorEmail"
            error=true
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
           binding.tilEmail.error = "Email is invalid"
            error=true
        }
        if (password.isBlank()){ binding.tilPassword.error="password is required"
            error=true
        }
        if(!error){
            startActivity(Intent(this, HomeActivity::class.java))
        }




    }

    }




