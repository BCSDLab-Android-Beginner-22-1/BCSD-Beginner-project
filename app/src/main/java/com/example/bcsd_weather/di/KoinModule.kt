package com.example.bcsd_weather.di

import android.app.Application
import androidx.room.Room
import com.example.bcsd_weather.db.local.LocalViewModel
import com.example.bcsd_weather.domain.repository.LocalRepository
import com.example.bcsd_weather.domain.usecase.GetLocalUseCase
import com.example.bcsd_weather.domain.usecase.InsertLocalUseCase
import com.exxample.bcsd_weather.data.dao.LocalDao
import com.exxample.bcsd_weather.data.db.LocalDatabase
import com.exxample.bcsd_weather.data.repository.LocalRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    fun provideDataBase(application: Application): LocalDatabase {

        return Room.databaseBuilder(application, LocalDatabase::class.java, "future_weather")
            .fallbackToDestructiveMigration()
            .build()

    }

    fun provideDao(dataBase: LocalDatabase): LocalDao {
        return dataBase.localDao()
    }

    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
    single { GetLocalUseCase(get()) }
    single { InsertLocalUseCase(get()) }
    single<LocalRepository> {LocalRepositoryImpl(get())  }

}

val viewModelModule = module {
    viewModel{LocalViewModel(get(),get(),get())}
}
