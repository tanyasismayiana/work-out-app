package dev.tanya.homeworkout.models

import com.google.gson.annotations.SerializedName

data class User(
@SerializedName("firstName") var firstName :String,
@SerializedName("lastName") var lastName :String,
var email:String,
@SerializedName("phoneNumber") var PhoneNumber :String,
@SerializedName("user_id") var userId :String





)


