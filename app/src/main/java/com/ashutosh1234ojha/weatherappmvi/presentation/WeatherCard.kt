package com.ashutosh1234ojha.weatherappmvi.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherCard(state: WeatherState, color: Color, modifier: Modifier=Modifier) {

    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            backgroundColor = color,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = "Today ${data.time.format(DateTimeFormatter.ofPattern("HH:mm"))}",
                    color = Color.White,
                )

                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = null, modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${data.temperatureCelsius}C",
                    color = Color.White, fontSize = 50.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${data.weatherType.weatherDesc}",
                    color = Color.White, fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherDataDisplay(
                        value = data.pressure.roundToInt(),
                        unit = "hpa",
                        icon = ImageVector.vectorResource(id = com.ashutosh1234ojha.weatherappmvi.R.drawable.ic_pressure),
                        iconTint = Color.White, textStyle = TextStyle(color = Color.White)
                    )
                    WeatherDataDisplay(
                        value = data.humidity.roundToInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = com.ashutosh1234ojha.weatherappmvi.R.drawable.ic_drop),
                        iconTint = Color.White, textStyle = TextStyle(color = Color.White)
                    )
                    WeatherDataDisplay(
                        value = data.windSpeed.roundToInt(),
                        unit = "km/h",
                        icon = ImageVector.vectorResource(id = com.ashutosh1234ojha.weatherappmvi.R.drawable.ic_wind),
                        iconTint = Color.White, textStyle = TextStyle(color = Color.White)
                    )
                }


            }

        }
    }

}