package com.example.weatherapp.repository

import android.arch.lifecycle.MutableLiveData
import com.example.weatherapp.model.CityWeather

interface Repository {
    fun getWeatherCity(city: String)
    fun getWeatherLocation( latitute: String, longitude: String)
    fun getWeatherResultData(): MutableLiveData<CityWeather>
}