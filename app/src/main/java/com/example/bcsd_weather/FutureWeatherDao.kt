package com.example.bcsd_weather.db.future

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bcsd_weather.data.FutureWeatherEntity
import com.example.bcsd_weather.data.UstWEATHER
import java.time.LocalDate

@Dao
interface FutureWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFutureWeather(futureWeatherEntity: List<FutureWeatherEntity>)

    // repository에서 startDate 매개변수에 LocalDate.now() 전달함
    @Query("select * from future_weather where date(fcstDate) >= date(:startDate)")
    fun getFutureWeather(startDate: String): LiveData<List<FutureWeatherEntity>>

    @Query("select * from future_weather where date(fcstDate) = date(:date)")
    fun getDetailedFutureWeather(date: String): LiveData<FutureWeatherEntity>

    @Query("delete from future_weather where date(fcstDate) < date(:firstDateToKeep)")
    fun deleteWeather(firstDateToKeep: String)

}