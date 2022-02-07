package com.bd.satellitetracking.domain.usecase

import com.bd.data.model.SatelliteDetail
import com.bd.data.repository.SatelliteRepository
import com.bd.satellitetracking.utils.Shared
import com.bd.satellitetracking.utils.SharedConstants
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSatelliteDetailUseCase(
    private val satelliteRepository: SatelliteRepository,
    private val shared: Shared,
    private val gson: Gson
) {
    suspend fun invoke(id: Int): Flow<SatelliteDetail> {
        return flow {
            val localDataStr = shared.getString("${SharedConstants.satelliteDetail}_$id", "")
            if (localDataStr.isNotEmpty()) {
                val localData = gson.fromJson(localDataStr, SatelliteDetail::class.java)
                emit(localData)
            } else {
                val data = satelliteRepository.getSatelliteDetailById(id)
                shared.put("${SharedConstants.satelliteDetail}_$id", gson.toJson(data))
                emit(data)
            }
        }
    }
}