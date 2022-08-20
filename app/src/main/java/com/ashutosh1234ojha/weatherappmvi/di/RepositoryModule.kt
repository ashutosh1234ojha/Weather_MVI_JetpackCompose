package com.ashutosh1234ojha.weatherappmvi.di

import com.ashutosh1234ojha.weatherappmvi.data.location.LocationTrackerImplementation
import com.ashutosh1234ojha.weatherappmvi.data.remote.WeatherApi
import com.ashutosh1234ojha.weatherappmvi.data.repository.WeatherRepositoryImplementation
import com.ashutosh1234ojha.weatherappmvi.domain.location.LocationTracker
import com.ashutosh1234ojha.weatherappmvi.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by Ashutosh Ojha on 20,August,2022
 */
@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImplementation: WeatherRepositoryImplementation): WeatherRepository
}