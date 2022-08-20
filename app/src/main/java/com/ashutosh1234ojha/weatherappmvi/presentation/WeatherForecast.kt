package com.ashutosh1234ojha.weatherappmvi.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Ashutosh Ojha on 21,August,2022
 */


@Composable
fun WeatherForecast(state: WeatherState, modifier: Modifier=Modifier) {

    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Today",
                color = Color.White, fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(content = {
                items(data) { weatherData ->
                    HourlyWeatherDisplay(
                        weatherData = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            })

        }
    }

}