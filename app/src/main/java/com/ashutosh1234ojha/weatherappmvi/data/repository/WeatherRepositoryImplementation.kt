package com.ashutosh1234ojha.weatherappmvi.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.ashutosh1234ojha.weatherappmvi.data.mappers.toWeatherInfo
import com.ashutosh1234ojha.weatherappmvi.data.remote.WeatherApi
import com.ashutosh1234ojha.weatherappmvi.domain.repository.WeatherRepository
import com.ashutosh1234ojha.weatherappmvi.domain.util.Resource
import com.ashutosh1234ojha.weatherappmvi.domain.weather.WeatherInfo
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */
class WeatherRepositoryImplementation @Inject constructor(val weatherApi: WeatherApi) :
    WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, lan: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(weatherApi.getWeatherData(lat, lan).toWeatherInfo())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Something went wrong")
        }
    }
}