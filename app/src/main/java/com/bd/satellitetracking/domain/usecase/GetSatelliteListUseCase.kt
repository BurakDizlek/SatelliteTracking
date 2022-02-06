package com.bd.satellitetracking.domain.usecase

import com.bd.data.model.Satellite
import com.bd.data.repository.SatelliteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSatelliteListUseCase(private val satelliteRepository: SatelliteRepository) {
    suspend fun invoke(): Flow<List<Satellite>> {
        return flow {
            emit(satelliteRepository.getSatelliteList())
        }
    }
}