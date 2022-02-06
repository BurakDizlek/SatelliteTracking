package com.bd.satellitetracking.domain.usecase

import com.bd.data.model.Position
import com.bd.data.repository.SatelliteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPositionsOfSatelliteUseCase(private val satelliteRepository: SatelliteRepository) {
    suspend fun invoke(id: Int): Flow<List<Position>> {
        return flow {
            emit(satelliteRepository.getPositionsById(id))
        }
    }
}