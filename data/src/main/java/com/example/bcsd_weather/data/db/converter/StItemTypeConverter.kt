package com.example.bcsd_weather.db.future.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.bcsd_weather.domain.model.StITEM
import com.google.gson.Gson

@ProvidedTypeConverter
class StItemTypeConverter() {

    @TypeConverter
    fun listToJson(value: StITEM): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): StITEM {
        return Gson().fromJson(value, StITEM::class.java)
    }
}