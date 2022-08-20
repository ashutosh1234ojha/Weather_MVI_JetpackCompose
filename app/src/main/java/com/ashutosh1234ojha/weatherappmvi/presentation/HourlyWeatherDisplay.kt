package com.ashutosh1234ojha.weatherappmvi.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashutosh1234ojha.weatherappmvi.domain.weather.WeatherData
import java.time.format.DateTimeFormatter

/**
 * Created by Ashutosh Ojha on 21,August,2022
 */

@SuppressLint("RememberReturnType")
@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier,
    textColor: Color = Color.White
) {
    val formattedTime = remember(weatherData) {
        weatherData.time.format(DateTimeFormatter.ofPattern("HH:mm"))
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = formattedTime,
            color = Color.LightGray
        )
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null, modifier = Modifier.width(40.dp)
        )
        Text(
            text = "${weatherData.temperatureCelsius}C",
            color = textColor, fontWeight = FontWeight.Bold
        )
    }

}