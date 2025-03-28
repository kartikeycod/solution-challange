package com.example.cropulse_kritrim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cropulse_kritrim.databinding.ActivityChattingPageBinding

class ChattingPageActivity : AppCompatActivity() {

    private val binding: ActivityChattingPageBinding by lazy {
        ActivityChattingPageBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }
    }
}