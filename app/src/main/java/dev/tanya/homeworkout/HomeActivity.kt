package dev.tanya.homeworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.tanya.homeworkout.databinding.ActivityHomeBinding
import dev.tanya.homeworkout.databinding.ActivityLoginBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding= ActivityHomeBinding.inflate(layoutInflater)
    setContentView(binding.root)
        castView()
        setupBottomNav()
    }
    fun castView(){

    }
    fun setupBottomNav(){
        binding.bnvHome.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.Plan ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,PlanFragment()).commit()
                    true
                }
                R.id.Track ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,TrackFragment()).commit()
                    true
                }
                R.id.Profile ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,profileFragment()).commit()
                    true
                }
                else->false
            }

        }

    }
}