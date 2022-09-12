package dev.tanya.homeworkout.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.tanya.homeworkout.LoginRequest
import dev.tanya.homeworkout.LoginResponse
import dev.tanya.homeworkout.models.RegisterRequest
import dev.tanya.homeworkout.models.RegisterResponse
import dev.tanya.homeworkout.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepository = UserRepository()
    val loginLiveData = MutableLiveData<LoginResponse>()
    val loginError = MutableLiveData<String>()
    val registerLiveData=MutableLiveData<RegisterResponse>()
    val registerError = MutableLiveData<String>()


    fun login(loginRequest:LoginRequest){
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else{
                loginError.postValue(response.errorBody()?.string())
            }
        }   }

    fun register(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepository.registerUser(registerRequest)
            if (response.isSuccessful){
                registerLiveData.postValue(response.body())
            }
            else{
                registerError.postValue(response.errorBody()?.string())
            }
        }
    }
}