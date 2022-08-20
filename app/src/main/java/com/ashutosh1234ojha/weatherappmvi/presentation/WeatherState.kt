package com.ashutosh1234ojha.weatherappmvi.presentation

import com.ashutosh1234ojha.weatherappmvi.domain.weather.WeatherInfo

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */
data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)