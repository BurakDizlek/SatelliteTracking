package com.bd.satellitetracking.presentation.list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bd.satellitetracking.databinding.FragmentSatelliteListBinding
import com.bd.satellitetracking.domain.base.BaseViewState
import com.bd.satellitetracking.presentation.MainViewModel
import com.bd.satellitetracking.utils.Config
import com.bd.satellitetracking.utils.addItemDecoration
import com.bd.satellitetracking.utils.hideKeyboard
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class SatelliteListFragment : Fragment() {

    private var _binding: FragmentSatelliteListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SatelliteListViewModel by viewModel()
    private val mainViewModel: MainViewModel by sharedViewModel()
    private val adapter = SatelliteListAdapter()
    private var timer: Timer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSatelliteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        setObservers()
        viewModel.getSatelliteList()
    }

    private fun setViews() {
        binding.recyclerView.apply {
            addItemDecoration()
            setHasFixedSize(true)
            adapter = this@SatelliteListFragment.adapter
        }

        binding.edtSearchBar.setOnEditorActionListener { textView, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.edtSearchBar.apply {
                    clearFocus()
                    hideKeyboard()
                }
                viewModel.searchText(text = textView.text.toString())
                true
            } else
                false
        }

        binding.edtSearchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                timer?.cancel()
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let { editable ->
                    if (editable.length >= Config.minCharacterToSearch || editable.isEmpty()) {
                        timer = Timer()
                        timer?.schedule(object : TimerTask() {
                            override fun run() {
                                viewModel.searchText(editable.toString())
                            }
                        }, Config.delayToSearch)
                    }
                }
            }
        })

        adapter.setOnItemClickListener { satellite ->
            findNavController().navigate(
                SatelliteListFragmentDirections.actionSatelliteListFragmentToSatelliteDetailFragment(
                    satellite.id,
                    satellite.name
                )
            )
        }
    }

    private fun setObservers() {
        viewModel.satelliteList.observe(viewLifecycleOwner, { data ->
            if (data is BaseViewState.Loading) { //Loading state control.
                mainViewModel.showLoading()
            } else {
                mainViewModel.hideLoading()
            }

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        timer = null
    }
}