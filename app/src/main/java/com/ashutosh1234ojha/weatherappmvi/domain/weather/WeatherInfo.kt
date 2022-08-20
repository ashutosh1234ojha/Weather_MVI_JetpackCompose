package com.ashutosh1234ojha.weatherappmvi.domain.weather

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */
data class WeatherInfo(val weatherDataPerDay: Map<Int, List<WeatherData>>,val currentWeatherData:WeatherData)
