package com.ashutosh1234ojha.weatherappmvi.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */
data class WeatherDto ( @field:Json(name="hourly") val  weatherData:WeatherDataDto)