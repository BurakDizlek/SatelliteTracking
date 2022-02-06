package com.bd.satellitetracking.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.dsl.module

val utilModule = module {
    single { createGson() }
}

private fun createGson(): Gson {
    return GsonBuilder().setDateFormat("yyyy-MM-dd").create()
}