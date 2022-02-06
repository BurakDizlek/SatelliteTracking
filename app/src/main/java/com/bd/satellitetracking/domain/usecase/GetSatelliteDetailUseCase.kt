package com.bd.satellitetracking.domain.usecase

import com.bd.data.model.SatelliteDetail
import com.bd.data.repository.SatelliteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSatelliteDetailUseCase(private val satelliteRepository: SatelliteRepository) {
    suspend fun invoke(id: Int): Flow<SatelliteDetail> {
        return flow {
            emit(satelliteRepository.getSatelliteDetailById(id))
        }
    }
}