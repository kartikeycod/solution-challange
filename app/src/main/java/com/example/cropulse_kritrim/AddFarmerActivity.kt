package com.example.cropulse_kritrim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cropulse_kritrim.databinding.ActivityAddFarmerBinding
import com.example.cropulse_kritrim.databinding.ActivityMainBinding

class AddFarmerActivity : AppCompatActivity() {
    private val binding : ActivityAddFarmerBinding by lazy {
    ActivityAddFarmerBinding.inflate(layoutInflater)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}