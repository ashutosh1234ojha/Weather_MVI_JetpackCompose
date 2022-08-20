package com.ashutosh1234ojha.weatherappmvi

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ashutosh1234ojha.weatherappmvi.presentation.WeatherCard
import com.ashutosh1234ojha.weatherappmvi.presentation.WeatherViewModel
import com.ashutosh1234ojha.weatherappmvi.presentation.ui.theme.DarkBlue
import com.ashutosh1234ojha.weatherappmvi.presentation.ui.theme.DeepBlue
import com.ashutosh1234ojha.weatherappmvi.presentation.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()
    private lateinit var premissionLauncer: ActivityResultLauncher<Array<String>>
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        premissionLauncer =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
                weatherViewModel.loadWeatherInfo()
            }

        weatherViewModel.loadWeatherInfo()
        premissionLauncer.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
        setContent {
            WeatherAppTheme {
                Column(
                    modifier = Modifier.fillMaxSize().background(DarkBlue)
                ) { WeatherCard(state = weatherViewModel.state, color = DeepBlue) }
            }
        }
    }
}