package com.example.bcsd_weather.di

import com.example.bcsd_weather.data.datasource.ShortTermForecastDataSource
import com.example.bcsd_weather.data.datasource.UltraShortTermFcstDataSource
import com.example.bcsd_weather.data.datasource.UltraShortTermLiveDataSource
import com.example.bcsd_weather.data.repository.ShortTermFcstRepositoryImpl
import com.example.bcsd_weather.data.repository.UltraSrtFcstRepositoryImpl
import com.example.bcsd_weather.data.repository.UltraSrtLiveRepositoryImpl
import com.example.bcsd_weather.domain.repository.ShortTermFcstRepository
import com.example.bcsd_weather.domain.repository.UltraSrtFcstRepository
import com.example.bcsd_weather.domain.repository.UltraSrtLiveRepository
import com.example.bcsd_weather.domain.usecase.GetShortTermFcstUseCase
import com.example.bcsd_weather.domain.usecase.GetUltraSrtFcstUseCase
import com.example.bcsd_weather.domain.usecase.GetUltraSrtLiveUseCase
import org.koin.dsl.module

val appModule = module {
    single<ShortTermFcstRepository> { ShortTermFcstRepositoryImpl(get()) }
    single<UltraSrtFcstRepository> { UltraSrtFcstRepositoryImpl(get()) }
    single<UltraSrtLiveRepository> { UltraSrtLiveRepositoryImpl(get()) }

    single { ShortTermForecastDataSource() }
    single { UltraShortTermFcstDataSource() }
    single { UltraShortTermLiveDataSource() }

    single { GetShortTermFcstUseCase(get()) }
    single { GetUltraSrtFcstUseCase(get()) }
    single { GetUltraSrtLiveUseCase(get()) }
}

val viewModelModule = module {

}
