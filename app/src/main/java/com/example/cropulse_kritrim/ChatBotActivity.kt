package com.example.cropulse_kritrim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cropulse_kritrim.databinding.ActivityChatBotBinding

class ChatBotActivity : AppCompatActivity() {

    private val binding : ActivityChatBotBinding by lazy {
        ActivityChatBotBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.getStartedChatBotBtn.setOnClickListener {
            val intent = Intent(this , ChattingPageActivity::class.java)
            startActivity(intent)
        }
        binding.backBtn.setOnClickListener {
            finish()
        }

    }
}