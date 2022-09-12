package dev.tanya.homeworkout.api

import dev.tanya.homeworkout.LoginRequest
import dev.tanya.homeworkout.LoginResponse
import dev.tanya.homeworkout.models.RegisterResponse
import dev.tanya.homeworkout.models.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

interface ApiInterface {
    @POST("/register")
    fun  registerUser(@Body registerRequest:RegisterRequest):Response<RegisterResponse>

    @POST("/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}