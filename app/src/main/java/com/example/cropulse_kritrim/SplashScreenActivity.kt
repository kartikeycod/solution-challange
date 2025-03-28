package com.example.cropulse_kritrim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cropulse_kritrim.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private val binding : ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.startBtnSplashScreen.setOnClickListener {
            val intent = Intent(this , OTPVerificationActivity::class.java)
            startActivity(intent)
        }

//        binding.splashScreenIV.setOnClickListener {
//            binding.splashScreenIV.animate().apply {
//                duration = 1000
//                rotationYBy(360f).withEndAction {
//                    binding.splashScreenIV.animate().apply {
//                        duration = 1000
//                        rotationXBy(360f).start()
//                    }
//                }
//            }
//        }

    }
}