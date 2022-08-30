package dev.tanya.homeworkout.models

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("firstName") var firstName :String,
    @SerializedName("lastName") var lastName :String,
    var email:String,
    @SerializedName("phoneNumber") var PhoneNumber :String,
    var password :String,







)
