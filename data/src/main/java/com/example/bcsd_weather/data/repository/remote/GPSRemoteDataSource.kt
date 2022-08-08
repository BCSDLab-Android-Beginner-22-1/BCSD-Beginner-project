package com.example.bcsd_weather.data.repository.remote

import com.example.bcsd_weather.data.model.GPSRemote

interface GPSRemoteDataSource {
    fun initGPS()
    fun getGPS(): GPSRemote?
}
