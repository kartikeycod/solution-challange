package com.example.cropulse_kritrim.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cropulse_kritrim.ChatBotActivity
import com.example.cropulse_kritrim.CommingSoonActivity
import com.example.cropulse_kritrim.R
import com.example.cropulse_kritrim.databinding.FragmentHomeBinding
import com.example.cropulse_kritrim.databinding.FragmentShopBinding

class ShopFragment : Fragment() {
    private lateinit var binding : FragmentShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShopBinding.inflate(inflater , container , false)

        binding.seedLLBtn.setOnClickListener {
            val intent = Intent(requireContext() , CommingSoonActivity::class.java)
            startActivity(intent)
        }

        binding.micronutrientLLBtn.setOnClickListener {
            val intent = Intent(requireContext() , CommingSoonActivity::class.java)
            startActivity(intent)
        }

        binding.fertilizerLLBtn.setOnClickListener {
            val intent = Intent(requireContext() , CommingSoonActivity::class.java)
            startActivity(intent)
        }

        binding.fungicideLLBtn.setOnClickListener {
            val intent = Intent(requireContext() , CommingSoonActivity::class.java)
            startActivity(intent)
        }

        binding.growthpromoterLLBtn.setOnClickListener {
            val intent = Intent(requireContext() , CommingSoonActivity::class.java)
            startActivity(intent)
        }

        binding.growthregulatorLLBtn.setOnClickListener {
            val intent = Intent(requireContext() , CommingSoonActivity::class.java)
            startActivity(intent)
        }

        binding.herbicideLLBtn.setOnClickListener {
            val intent = Intent(requireContext() , CommingSoonActivity::class.java)
            startActivity(intent)
        }

        binding.seemoreLLBtn.setOnClickListener {
            val intent = Intent(requireContext() , CommingSoonActivity::class.java)
            startActivity(intent)
        }
        binding.chatBotButton.setOnClickListener {
            val intent = Intent(requireContext() , ChatBotActivity::class.java)
            startActivity(intent)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
    }

}