package com.ashutosh1234ojha.weatherappmvi.domain.repository

import com.ashutosh1234ojha.weatherappmvi.domain.util.Resource
import com.ashutosh1234ojha.weatherappmvi.domain.weather.WeatherInfo

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */
interface WeatherRepository {

    suspend fun getWeatherData(lat: Double, lan: Double): Resource<WeatherInfo>
}