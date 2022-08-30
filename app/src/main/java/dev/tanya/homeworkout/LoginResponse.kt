package dev.tanya.homeworkout

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var message:String,
    @SerializedName("access_taken")var accessToken:String,
    @SerializedName("user_id")var userId:String,
    @SerializedName("profile_id")var profileId:String



)
