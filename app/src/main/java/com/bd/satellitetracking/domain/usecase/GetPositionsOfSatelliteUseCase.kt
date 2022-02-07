package com.bd.satellitetracking.domain.usecase

import com.bd.data.model.Position
import com.bd.data.repository.SatelliteRepository
import com.bd.satellitetracking.utils.Config
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPositionsOfSatelliteUseCase(private val satelliteRepository: SatelliteRepository) {
    suspend fun invoke(id: Int): Flow<Position> {
        return flow {
            val positionList = satelliteRepository.getPositionsById(id)
            if (positionList.isNotEmpty()) {
                var index = 0
                while (true) {
                    emit(positionList[index])
                    if (index == positionList.size - 1)
                        index = 0
                    else
                        index++
                    delay(Config.positionRefreshPeriod)
                }
            }
        }
    }
}