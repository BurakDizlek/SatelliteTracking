package com.bd.satellitetracking.datasource

import android.content.Context
import com.bd.data.model.*
import com.bd.data.repository.SatelliteRepository
import com.bd.satellitetracking.utils.readAssetsFile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SatelliteRepositoryImp(
    private val context: Context,
    private val gson: Gson
) : SatelliteRepository {

    override suspend fun getSatelliteList(): List<Satellite> =
        withContext(Dispatchers.Default) {
            val listType = object : TypeToken<List<Satellite>>() {}.type
            return@withContext gson.fromJson(
                context.assets.readAssetsFile("satellites.json"),
                listType
            )
        }

    override suspend fun getSatelliteDetailById(id: Int): SatelliteDetail =
        withContext(Dispatchers.Default) {
            val listType = object : TypeToken<List<SatelliteDetail>>() {}.type
            val detailList: List<SatelliteDetail> =
                gson.fromJson(context.assets.readAssetsFile("satellite-detail.json"), listType)
            return@withContext detailList.first { it.id == id }
        }

    override suspend fun getPositionsById(id: Int): List<Position> =
        withContext(Dispatchers.Default) {
            val positionList = gson.fromJson(
                context.assets.readAssetsFile("positions.json"),
                SatellitePositionsList::class.java
            )
            return@withContext positionList.list.first { it.id == id.toString() }.positions
        }
}