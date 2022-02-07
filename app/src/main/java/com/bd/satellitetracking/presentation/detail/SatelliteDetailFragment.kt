package com.bd.satellitetracking.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bd.satellitetracking.databinding.FragmentSatelliteDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SatelliteDetailFragment : Fragment() {

    private var _binding: FragmentSatelliteDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SatelliteDetailViewModel by viewModel()
    private val args: SatelliteDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSatelliteDetailBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = viewLifecycleOwner
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            binding.vm = this
            setTitle(args.satelliteName)
            getSatelliteDetailById(args.satelliteId)
            getSatellitePositionById(args.satelliteId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}