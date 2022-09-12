package dev.tanya.homeworkout.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.tanya.homeworkout.api.ApiInterface
import dev.tanya.homeworkout.LoginRequest
import dev.tanya.homeworkout.LoginResponse
import dev.tanya.homeworkout.databinding.ActivityLoginBinding
import dev.tanya.homeworkout.api.ApiClient
import dev.tanya.homeworkout.viewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSignUp.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            validateLogin()

        }
        sharedPrefs = getSharedPreferences("HOMEWORKOUT_PREFS", MODE_PRIVATE)
    }

    override fun onResume() {
        super.onResume()
        UserViewModel().loginLiveData.observe(this, Observer{loginResponse->
            Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_LONG)
                .show()
            persistLoginDetails(loginResponse!!)

            startActivity(Intent(baseContext, HomeActivity::class.java))
        })

    }

    fun validateLogin() {
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var error = false


        if (email.isBlank()) {
            binding.tilEmail.error = "@string/errorEmail"
            error = true
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Email is invalid"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "password is required"
            error = true
        }
        if (!error) {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        if (!error) {
            val loginRequest = LoginRequest(email, password)
            userViewModel.login(loginRequest)
        }
    }

    fun persistLoginDetails(loginResponse: LoginResponse) {
        val editor = sharedPrefs.edit()
        editor.putString("USER_ID", loginResponse.userId)
        editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
        editor.putString("PROFILE_ID", loginResponse.profileId)
        editor.apply()

    }
}




