package com.bd.satellitetracking.di

import com.bd.satellitetracking.presentation.MainViewModel
import com.bd.satellitetracking.presentation.list.SatelliteListViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { SatelliteListViewModel(get()) }
    single { MainViewModel() }
}