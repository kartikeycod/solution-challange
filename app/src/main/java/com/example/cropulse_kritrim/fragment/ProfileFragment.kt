package com.example.cropulse_kritrim.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.cropulse_kritrim.R
import com.example.cropulse_kritrim.databinding.FragmentProfileBinding
import com.example.cropulse_kritrim.databinding.FragmentShopBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(inflater , container , false)

        binding.imageSelector.setOnClickListener {
            pickImageForFarmer.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
        binding.selectShopImage.setOnClickListener {
            pickImageForShop.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }



        // Inflate the layout for this fragment
        return binding.root
    }

    val pickImageForFarmer = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            binding.farmerImage.setImageURI(uri)
        }
    }
    val pickImageForShop = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            binding.selectedImage.setImageURI(uri)
        }
    }

    companion object {
    }
}