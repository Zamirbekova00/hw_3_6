package com.example.hw_3_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hw_3_6.databinding.FragmentButtonBinding

class ButtonFragment : Fragment() {
    private lateinit var binding: FragmentButtonBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentButtonBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        initListener()
    }

    private fun initListener() {
        binding.btnPlus.setOnClickListener {
            viewModel.increment()
        }
        binding.btnMinus.setOnClickListener {
            viewModel.decrement()
        }
    }
}



