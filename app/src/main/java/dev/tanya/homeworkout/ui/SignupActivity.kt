package dev.tanya.homeworkout.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.tanya.homeworkout.api.ApiInterface
import dev.tanya.homeworkout.R
import dev.tanya.homeworkout.databinding.ActivitySignupBinding
import dev.tanya.homeworkout.api.ApiClient
import dev.tanya.homeworkout.models.RegisterResponse
import dev.tanya.homeworkout.models.RegisterRequest
import dev.tanya.homeworkout.viewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    lateinit var sharedPrefs : SharedPreferences
    val userViewModel: UserViewModel by viewModels()

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
        sharedPrefs = getSharedPreferences("HOMEWORKOUT_PREFS", MODE_PRIVATE)

    }
    override fun onResume() {
        super.onResume()
        UserViewModel().loginLiveData.observe(this, Observer{RegisterResponse->
            Toast.makeText(baseContext, RegisterResponse?.message, Toast.LENGTH_LONG)
                .show()
            startActivity(Intent(baseContext, HomeActivity::class.java))
        })

    }

    fun validateSignup2(){
        var email =binding.etEmail2.text.toString()
        var password=binding.etPassword2.text.toString()
        var FirstName=binding.etFirstName.text.toString()
        var LastName= binding.etLastName.text.toString()
        var PhoneNumber= binding.etPhoneNumber.toString()
        var ConfirmPassword= binding.etConfirmPassword.text.toString()


        var error =false

        if (email.isBlank()) {
            error = true
            binding.tilEmail2.error = "@string/errorEmail"
        }
        if (password.isBlank()){
            error = true
            binding.tilPassword2.error="password is required"
        }
        if (FirstName.isBlank()){
            error = true
            binding.tilFirstName.error="Name is required"
        }
        if (LastName.isBlank()){
            error = true
            binding.tilLastName.error="name is required"
        }
        if (ConfirmPassword.isBlank()){
            error = true
            binding.tilConfirmPassword.error="password is required"
        }
        if (ConfirmPassword != password){
            error = true
            binding.etPassword2.error ="password not matched"
        }
        if (PhoneNumber.isBlank()) {
            error = true
            binding.etPhoneNumber.error = "@string/errorPhoneNumber"
        }
         if (!error){
             var registerRequest = RegisterRequest(FirstName,LastName,PhoneNumber,email,password)
             userViewModel.register(registerRequest)
         }


    }



}





