package com.example.cropulse_kritrim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cropulse_kritrim.databinding.ActivityCropDoctorBinding
import com.example.cropulse_kritrim.databinding.ActivityEnterOtpactivityBinding

class CropDoctorActivity : AppCompatActivity() {
    private val binding: ActivityCropDoctorBinding by lazy {
        ActivityCropDoctorBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backBtn.setOnClickListener {
            finish()
        }
        binding.chatBotButton.setOnClickListener {
            startActivity(Intent(this,ChatBotActivity::class.java))
        }
    }
}
