package com.bd.satellitetracking.di

import com.bd.satellitetracking.domain.usecase.GetPositionsOfSatelliteUseCase
import com.bd.satellitetracking.domain.usecase.GetSatelliteDetailUseCase
import com.bd.satellitetracking.domain.usecase.GetSatelliteListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetSatelliteListUseCase(get()) }
    single { GetSatelliteDetailUseCase(get(), get(), get()) }
    single { GetPositionsOfSatelliteUseCase(get()) }
}