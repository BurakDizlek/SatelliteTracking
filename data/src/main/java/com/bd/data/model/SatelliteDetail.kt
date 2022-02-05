package com.bd.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class SatelliteDetail(
    val id: String,
    @SerializedName("cost_per_launch")
    val costPerLaunch: Int,
    @SerializedName("first_flight")
    val firstFlight: Date,
    val height: Int,
    val mass: Int
)