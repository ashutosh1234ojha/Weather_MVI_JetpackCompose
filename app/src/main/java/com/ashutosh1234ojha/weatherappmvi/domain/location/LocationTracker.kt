package com.ashutosh1234ojha.weatherappmvi.domain.location

import android.location.Location

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */
interface LocationTracker {
    suspend fun getCurrentLocation():Location ?
}