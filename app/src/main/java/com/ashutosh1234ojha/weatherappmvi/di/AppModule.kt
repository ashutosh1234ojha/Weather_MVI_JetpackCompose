package com.ashutosh1234ojha.weatherappmvi.di

import android.app.Application
import com.ashutosh1234ojha.weatherappmvi.data.remote.WeatherApi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(MoshiConverterFactory.create()).build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app:Application):FusedLocationProviderClient{
        return LocationServices.getFusedLocationProviderClient(app)

    }
}