package com.bd.data.repository

import com.bd.data.model.Satellite
import com.bd.data.model.SatelliteDetail
import com.bd.data.model.SatellitePositions

interface SatelliteRepository {

    suspend fun getSatelliteList(): List<Satellite>

    suspend fun getSatelliteDetail(satelliteId: Int): SatelliteDetail

    suspend fun getPositions(satelliteId: Int): SatellitePositions
}