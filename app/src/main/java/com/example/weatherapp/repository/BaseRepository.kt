package com.example.weatherapp.repository

import com.example.weatherapp.di.DaggerRepositoryInjector
import com.example.weatherapp.di.NetworkModule
import com.example.weatherapp.di.RepositoryInjector

abstract class BaseRepository {
    private val injector: RepositoryInjector = DaggerRepositoryInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is WeatherRepository -> injector.inject(this)
        }
    }
}