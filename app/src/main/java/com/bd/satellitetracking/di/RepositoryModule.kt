package com.bd.satellitetracking.di

import com.bd.satellitetracking.datasource.SatelliteRepositoryImp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single { SatelliteRepositoryImp(androidContext(), get()) }
}