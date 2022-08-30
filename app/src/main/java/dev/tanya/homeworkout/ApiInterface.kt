package dev.tanya.homeworkout

import dev.tanya.homeworkout.models.RegisterResponse
import dev.tanya.homeworkout.models.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

interface ApiInterface {
    @POST("/register")
    fun  registerUser(@Body registerRequest:RegisterRequest):Call<RegisterResponse>
    @POST("/login")
    fun loginUser(@Body loginRequest: LoginRequest):Call <LoginResponse>
}