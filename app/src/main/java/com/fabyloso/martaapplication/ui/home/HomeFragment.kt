package com.fabyloso.martaapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.fabyloso.martaapplication.R
import com.fabyloso.martaapplication.autoCleared
import com.fabyloso.martaapplication.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding by autoCleared()
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false).apply {
        }

        val textView: TextView = binding.textHome

        homeViewModel.fetchTrains()
        homeViewModel.trainsLiveData.observe(viewLifecycleOwner, Observer {
            textView.text = it?.data?.get(0)?.destination
        })
        return binding.root
    }
}