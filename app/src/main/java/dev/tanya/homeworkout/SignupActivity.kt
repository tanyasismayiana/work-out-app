package dev.tanya.homeworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.tanya.homeworkout.databinding.ActivityLoginBinding
import dev.tanya.homeworkout.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogin2.setOnClickListener {
            var intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup2.setOnClickListener {
            validateSignup2()

        }
    }
    fun validateSignup2(){
        var email =binding.etEmail2.text.toString()
        var password=binding.etPassword2.text.toString()
        var FirstName=binding.etFirstName.text.toString()
        var LastName= binding.etLastName.text.toString()
        var Password= binding.etPassword2.text.toString()
        var ConfirmPassword= binding.etConfirmPassword.text.toString()

        if (email.isBlank()) {
            binding.tilEmail2.error = "@string/errorEmail"
        }
        if (password.isBlank()){
            binding.tilPassword2.error="password is required"
        }
        if (FirstName.isBlank()){
            binding.tilFirstName.error="Name is required"
        }
        if (LastName.isBlank()){
            binding.tilLastName.error="name is required"
        }
        if (ConfirmPassword.isBlank()){
            binding.tilConfirmPassword.error="password is required"
        }
        if (ConfirmPassword != password){
            binding.etPassword2.error ="password not matched"
        }




    }

}


