package com.example.bcsd_weather

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.bcsd_weather.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
        }
    }
}
