package com.ashutosh1234ojha.weatherappmvi.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashutosh1234ojha.weatherappmvi.domain.location.LocationTracker
import com.ashutosh1234ojha.weatherappmvi.domain.repository.WeatherRepository
import com.ashutosh1234ojha.weatherappmvi.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */
@HiltViewModel
class WeatherViewModel @Inject constructor(
    val repository: WeatherRepository,
    val locationTracker: LocationTracker
) : ViewModel() {
    var state by mutableStateOf(WeatherState())

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)

            locationTracker.getCurrentLocation()?.let {
                when (val result = repository.getWeatherData(it.latitude, it.longitude)) {
                    is Resource.Success -> {
                        state =
                            state.copy(isLoading = false, error = null, weatherInfo = result.data)
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            isLoading = false,
                            error = result.message,
                            weatherInfo = null
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "no location  found, please  check  permission",
                    weatherInfo = null
                )
            }
        }
    }
}