package com.dynamicdevz.ddkotlinmvp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynamicdevz.ddkotlinmvp.databinding.ImageFragmentLayoutBinding

class ImageFragment: Fragment() {

    private lateinit var binding: ImageFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =  ImageFragmentLayoutBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            Glide.with(view)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load(it.getString("KEY"))
                .into(binding.fragmentImageview)
        }
    }



}