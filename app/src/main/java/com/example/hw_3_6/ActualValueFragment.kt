package com.example.hw_3_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import com.example.hw_3_6.databinding.FragmentActualValueBinding

class ActualValueFragment : Fragment() {
    private lateinit var binding: FragmentActualValueBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentActualValueBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        initObserver()
    }

    private fun initObserver() {
        viewModel.mCounter.observe(viewLifecycleOwner) {
            binding.tvValue.text = it.toString()
        }
    }
}