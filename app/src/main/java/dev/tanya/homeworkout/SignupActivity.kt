package dev.tanya.homeworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var etFirstName: TextInputEditText
    lateinit var tilFirstName:TextInputLayout
    lateinit var etLastName: TextInputEditText
    lateinit var tilLastName:TextInputLayout
    lateinit var etEmail2:TextInputEditText
    lateinit var tilEmail2: TextInputLayout
    lateinit var etPassword2:TextInputEditText
    lateinit var tilPassword2: TextInputLayout
    lateinit var etConfirmPassword:TextInputEditText
    lateinit var tilconfirmPassword:TextInputLayout
    lateinit var tvLogin2: TextView
    lateinit var btnSignup2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        etFirstName=findViewById(R.id.etFirstName)
        etLastName=findViewById(R.id.etLastName)
        tilFirstName=findViewById(R.id.tilFirstName)
        tilconfirmPassword=findViewById(R.id.tilConfirmPassword)
        etConfirmPassword=findViewById(R.id.etConfirmPassword)
        tilLastName=findViewById(R.id.tilLastName)
        etEmail2=findViewById(R.id.etEmail2)
        etPassword2=findViewById(R.id.etPassword2)
        tilPassword2=findViewById(R.id.tilPassword2)
        tilEmail2=findViewById(R.id.tilEmail2)
        btnSignup2=findViewById(R.id.btnSignup2)
        tvLogin2=findViewById(R.id.tvLogin2)

        tvLogin2.setOnClickListener {
            var intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnSignup2.setOnClickListener {
            validateSignup2()

        }
    }
    fun validateSignup2(){
        var email =etEmail2.text.toString()
        var password=etPassword2.text.toString()
        var FirstName=etFirstName.text.toString()
        var LastName= etLastName.text.toString()
        var Password= etPassword2.text.toString()
        var ConfirmPassword= etConfirmPassword.text.toString()

        if (email.isBlank()) {
            tilEmail2.error = "@string/errorEmail"
        }
        if (password.isBlank()){
            tilPassword2.error="password is required"
        }
        if (FirstName.isBlank()){
            tilFirstName.error="Name is required"
        }
        if (LastName.isBlank()){
            tilLastName.error="name is required"
        }
        if (ConfirmPassword.isBlank()){
            tilconfirmPassword.error="password is required"
        }



    }

}


