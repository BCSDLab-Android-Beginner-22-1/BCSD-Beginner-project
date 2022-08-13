package com.example.bcsd_weather.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.bcsd_weather.domain.model.FutureWeatherEntity
import java.time.LocalDate

@Dao
interface FutureWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFutureWeather(futureWeatherEntity: FutureWeatherEntity)

    @Query("select * from future_weather where date(fcstDate) >= date(:startDate)")
    fun getFutureWeather(startDate: String): LiveData<List<FutureWeatherEntity>>

    @Query("select * from future_weather where date(fcstDate) = date(:date)")
    fun getDetailedFutureWeather(date: String): LiveData<FutureWeatherEntity>

    @Query("delete from future_weather where date(fcstDate) < date(:firstDateToKeep)")
    fun deleteWeather(firstDateToKeep: String)

}