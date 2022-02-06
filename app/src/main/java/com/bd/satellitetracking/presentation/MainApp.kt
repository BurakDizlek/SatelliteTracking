package com.bd.satellitetracking.presentation

import android.app.Application
import com.bd.satellitetracking.di.repositoryModule
import com.bd.satellitetracking.di.utilModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApp)
            modules(
                utilModule,
                repositoryModule
            )
        }
    }
}