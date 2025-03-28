package com.example.cropulse_kritrim.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cropulse_kritrim.AboutCropActivity
import com.example.cropulse_kritrim.AddFarmerActivity
import com.example.cropulse_kritrim.BuyProductActivity
import com.example.cropulse_kritrim.ChatBotActivity
import com.example.cropulse_kritrim.CommingSoonActivity
import com.example.cropulse_kritrim.CropDoctorActivity
import com.example.cropulse_kritrim.MakeMoneyActivity
import com.example.cropulse_kritrim.MarketingActivity
import com.example.cropulse_kritrim.R
import com.example.cropulse_kritrim.WeatherActivity
import com.example.cropulse_kritrim.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.buyProductLL.setOnClickListener {
            val intent = Intent(requireContext() , BuyProductActivity::class.java)
            startActivity(intent)
        }
        binding.makeMoneyLL.setOnClickListener {
            val intent = Intent(requireContext() , CommingSoonActivity::class.java)
            startActivity(intent)
        }
        binding.aboutCropLL.setOnClickListener {
            val intent = Intent(requireContext() , AboutCropActivity::class.java)
            startActivity(intent)
        }
        binding.cropDoctorLL.setOnClickListener {
            val intent = Intent(requireContext() , CropDoctorActivity::class.java)
            startActivity(intent)
        }
        binding.weatherLL.setOnClickListener {
            val intent = Intent(requireContext() , WeatherActivity::class.java)
            startActivity(intent)
        }
        binding.addFarmer.setOnClickListener {
            val intent = Intent(requireContext() , CommingSoonActivity::class.java)
            startActivity(intent)
        }
        binding.chatBotButton.setOnClickListener {
            val intent = Intent(requireContext() , ChatBotActivity::class.java)
            startActivity(intent)
        }

        return binding.root

    }


    companion object {}

}
