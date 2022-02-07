package com.bd.satellitetracking.di

import com.bd.satellitetracking.presentation.MainViewModel
import com.bd.satellitetracking.presentation.detail.SatelliteDetailViewModel
import com.bd.satellitetracking.presentation.list.SatelliteListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SatelliteListViewModel(get()) }
    viewModel { MainViewModel() }
    viewModel { SatelliteDetailViewModel(get(),get()) }
}