package dev.tanya.homeworkout.models
import com.google.gson.annotations.SerializedName
data class ProfileResponse(
    @SerializedName("name")var name:String,
    @SerializedName("sex")var sex:String,
    @SerializedName("date_of_birth")var dateofbirth:String
)
