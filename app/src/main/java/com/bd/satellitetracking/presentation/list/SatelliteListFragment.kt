package com.bd.satellitetracking.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bd.satellitetracking.R
import com.bd.satellitetracking.databinding.FragmentSatelliteListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SatelliteListFragment : Fragment() {

    private var _binding: FragmentSatelliteListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSatelliteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
         //   findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment) //todo will add a parameter here!
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}