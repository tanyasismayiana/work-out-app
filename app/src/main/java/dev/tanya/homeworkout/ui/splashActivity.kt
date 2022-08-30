package dev.tanya.homeworkout.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class splashActivity : AppCompatActivity() {
    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs = getSharedPreferences("HOMEWORKOUT_PREFS", MODE_PRIVATE)
        var  accessToken = sharedPrefs.getString("ACCESS_TOKEN","").toString()
        if (accessToken.isBlank()){
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        else{
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        finish()
    }
}