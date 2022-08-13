package com.example.bcsd_weather.db.future.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.bcsd_weather.domain.model.ShortTermForecastModel
import com.google.gson.Gson

@ProvidedTypeConverter
class shortTermForecastModelTypeConverter() {

    @TypeConverter
    fun stfToJson(value: ShortTermForecastModel): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToStf(value: String): ShortTermForecastModel {
        return Gson().fromJson(value, ShortTermForecastModel::class.java)
    }

}