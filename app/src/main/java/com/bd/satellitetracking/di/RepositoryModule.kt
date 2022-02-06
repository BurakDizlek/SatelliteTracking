package com.bd.satellitetracking.di

import com.bd.data.repository.SatelliteRepository
import com.bd.satellitetracking.datasource.SatelliteRepositoryImp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<SatelliteRepository> { SatelliteRepositoryImp(androidContext(), get()) }
}