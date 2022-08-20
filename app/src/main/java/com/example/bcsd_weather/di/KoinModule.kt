package com.example.bcsd_weather.di

import android.app.Application
import androidx.room.Room
import com.example.bcsd_weather.domain.repository.LocalRepository
import com.example.bcsd_weather.domain.usecase.DeleteLocalUseCase
import com.example.bcsd_weather.domain.usecase.GetLocalUseCase
import com.example.bcsd_weather.domain.usecase.InsertLocalUseCase
import com.example.bcsd_weather.data.dao.LocalDao
import com.example.bcsd_weather.data.db.LocalDatabase
import com.example.bcsd_weather.data.repository.LocalRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    fun localProvideDataBase(application: Application): LocalDatabase {

        return Room.databaseBuilder(application, LocalDatabase::class.java, "localDataTable")
            .fallbackToDestructiveMigration()
            .build()

    }

    fun localProvideDao(dataBase: LocalDatabase): LocalDao {
        return dataBase.localDao()
    }

    single { localProvideDataBase(androidApplication()) }
    single { localProvideDao(get()) }
    single { GetLocalUseCase(get()) }
    single { InsertLocalUseCase(get()) }
    single { DeleteLocalUseCase(get()) }
    single<LocalRepository> {LocalRepositoryImpl(get())  }

}


