package dev.tanya.homeworkout.repository

import dev.tanya.homeworkout.api.ApiInterface
import dev.tanya.homeworkout.LoginRequest
import dev.tanya.homeworkout.LoginResponse
import dev.tanya.homeworkout.api.ApiClient
import dev.tanya.homeworkout.models.RegisterRequest
import dev.tanya.homeworkout.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest:LoginRequest):Response<LoginResponse> =
        withContext(Dispatchers.IO){
            val response = apiClient.loginUser(loginRequest)
            return@withContext response
        }
    suspend fun registerUser(registerRequest: RegisterRequest):Response<RegisterResponse> =
        withContext(Dispatchers.IO){
            val response=apiClient.registerUser(registerRequest)
            return@withContext response
        }
}
