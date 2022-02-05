package com.bd.data.repository

import com.bd.data.model.Position
import com.bd.data.model.Satellite
import com.bd.data.model.SatelliteDetail

interface SatelliteRepository {

    suspend fun getSatelliteList(): List<Satellite>

    suspend fun getSatelliteDetailById(id: Int): SatelliteDetail

    suspend fun getPositionsById(id: Int): List<Position>
}