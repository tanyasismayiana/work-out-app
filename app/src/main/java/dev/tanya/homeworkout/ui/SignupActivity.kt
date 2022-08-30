package dev.tanya.homeworkout.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.tanya.homeworkout.ApiInterface
import dev.tanya.homeworkout.R
import dev.tanya.homeworkout.databinding.ActivitySignupBinding
import dev.tanya.homeworkout.models.ApiClient
import dev.tanya.homeworkout.models.RegisterResponse
import dev.tanya.homeworkout.models.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
             makeRegistrationRequest(registerRequest)
         }


    }

    fun makeRegistrationRequest(registerRequest: RegisterRequest){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.registerUser(registerRequest)

        request.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    var message= response.body()?.message
                    Toast.makeText(baseContext,message,Toast.LENGTH_LONG).show()
                    startActivity(Intent(baseContext,LoginActivity::class.java))
                }
                else {
                    var error = response.errorBody()?.string()
                    Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })

    }




}

