package com.example.bcsd_weather

import android.app.Application
import com.example.bcsd_weather.di.appModule
import com.example.bcsd_weather.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(listOf(appModule, viewModelModule))
        }
    }
}
