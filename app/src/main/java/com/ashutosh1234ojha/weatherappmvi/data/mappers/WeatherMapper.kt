package com.ashutosh1234ojha.weatherappmvi.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.ashutosh1234ojha.weatherappmvi.data.remote.WeatherDataDto
import com.ashutosh1234ojha.weatherappmvi.data.remote.WeatherDto
import com.ashutosh1234ojha.weatherappmvi.domain.weather.WeatherData
import com.ashutosh1234ojha.weatherappmvi.domain.weather.WeatherInfo
import com.ashutosh1234ojha.weatherappmvi.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */

private data class IndexedWeatherData(val index: Int, val data: WeatherData)

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperature[index]
        val weatherCode = weatherCode[index]
        val pressure = pressure_msl[index]
        val windSpeed = windSpeeds[index]
        val humidity = humidity[index]
        IndexedWeatherData(
            index, WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                weatherType = WeatherType.fromWMO(weatherCode),
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity
            )
        )
    }.groupBy { it.index / 24 }.mapValues {
        it.value.map { it -> it.data }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeatherInfo(): WeatherInfo {

    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(weatherDataPerDay = weatherDataMap, currentWeatherData = currentWeatherData!!)

}