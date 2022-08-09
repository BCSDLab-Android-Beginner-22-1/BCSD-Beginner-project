package com.example.bcsd_weather.db.future.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.bcsd_weather.data.ShortTermForecastModel
import com.google.gson.Gson

@ProvidedTypeConverter
class shortTermForecastModelTypeConverter(private val gson: Gson) {

    @TypeConverter
    fun stfToJson(value: ShortTermForecastModel): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun jsonToStf(value: String): ShortTermForecastModel {
        return gson.fromJson(value, ShortTermForecastModel::class.java)
    }

}