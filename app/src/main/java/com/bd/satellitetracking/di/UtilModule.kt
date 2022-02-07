package com.bd.satellitetracking.di

import com.bd.satellitetracking.utils.Shared
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilModule = module {
    single { createGson() }
    single { Shared(androidContext()) }
}

private fun createGson(): Gson {
    return GsonBuilder().setDateFormat("yyyy-MM-dd").create()
}