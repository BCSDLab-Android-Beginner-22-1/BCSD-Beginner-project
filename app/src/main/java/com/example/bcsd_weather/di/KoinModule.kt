package com.example.bcsd_weather.di

import android.app.Application
import androidx.room.Room
import com.example.bcsd_weather.domain.repository.TempRepository
import com.example.bcsd_weather.domain.usecase.DeleteTempUseCase
import com.example.bcsd_weather.domain.usecase.GetTempUseCase
import com.example.bcsd_weather.domain.usecase.InsertTempUseCase
import com.example.bcsd_weather.data.dao.TempDao
import com.example.bcsd_weather.data.db.TempDatabase
import com.example.bcsd_weather.data.repository.TempRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    fun TempProvideDataBase(application: Application): TempDatabase {

        return Room.databaseBuilder(application, TempDatabase::class.java, "TempDataTable")
            .fallbackToDestructiveMigration()
            .build()

    }

    fun TempProvideDao(dataBase: TempDatabase): TempDao {
        return dataBase.tempDao()
    }

    single { TempProvideDataBase(androidApplication()) }
    single { TempProvideDao(get()) }
    single { GetTempUseCase(get()) }
    single { InsertTempUseCase(get()) }
    single { DeleteTempUseCase(get()) }
    single<TempRepository> {TempRepositoryImpl(get())  }

}


