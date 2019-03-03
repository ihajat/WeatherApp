package com.example.weatherapp.di

import com.example.weatherapp.repository.WeatherRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface RepositoryInjector {
    /**
     * Injects required dependencies into the specified WeatherRepository.
     * @param weatherRepository WeatherRepository in which to inject the dependencies
     */
    fun inject(weatherRepository: WeatherRepository)

    @Component.Builder
    interface Builder {
        fun build(): RepositoryInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}