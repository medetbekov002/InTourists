package com.dev.intourist.ui.screen.filters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.intourist.R
import com.dev.intourist.databinding.FragmentFiltersBinding

class FiltersFragment : Fragment() {

    private lateinit var binding: FragmentFiltersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFiltersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sbPriceRange.setMax(5000)
    }
}