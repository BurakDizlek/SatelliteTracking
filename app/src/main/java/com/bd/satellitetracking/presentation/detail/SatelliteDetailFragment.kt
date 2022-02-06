package com.bd.satellitetracking.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bd.satellitetracking.databinding.FragmentSatelliteDetailBinding
import com.bd.satellitetracking.domain.base.BaseViewState
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
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        viewModel.getSatelliteDetailById(args.satelliteId)
    }

    private fun setObservers() {
        viewModel.satelliteDetail.observe(viewLifecycleOwner, { data ->
            if (data is BaseViewState.Success) {
                //todo we have detail data now
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}