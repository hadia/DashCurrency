package com.hadia.task.dashcurrency

import android.app.Application
import com.hadia.task.dashcurrency.di.applicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DashApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@DashApp)
            modules(applicationModules)
        }
    }
}
