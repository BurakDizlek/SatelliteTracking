package com.bd.satellitetracking.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bd.satellitetracking.databinding.FragmentSatelliteListBinding
import com.bd.satellitetracking.domain.base.BaseViewState
import com.bd.satellitetracking.utils.addItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class SatelliteListFragment : Fragment() {

    private var _binding: FragmentSatelliteListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SatelliteListViewModel by viewModel()
    private val adapter = SatelliteListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSatelliteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            addItemDecoration()
            setHasFixedSize(true)
            adapter = this@SatelliteListFragment.adapter
        }

        adapter.setOnItemClickListener {
            Toast.makeText(requireContext(), "will be opened the next screen", Toast.LENGTH_SHORT)
                .show()
        }

        viewModel.satelliteList.observe(viewLifecycleOwner, { data ->
            when (data) {
                is BaseViewState.Success -> {
                    adapter.setData(data.data)
                }
                is BaseViewState.Error -> {
                }
                is BaseViewState.Loading -> {
                }
                is BaseViewState.NoData -> {
                }
            }
        })
        viewModel.getSatelliteList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}