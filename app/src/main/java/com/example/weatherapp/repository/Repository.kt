package com.example.weatherapp.repository

import android.arch.lifecycle.MutableLiveData
import com.example.weatherapp.model.CityWeather

interface Repository {
    fun getWeatherCity(_city: String)
    fun getWeatherLocation( _latitute: String, _longitude: String)
    fun getWeatherResultData(): MutableLiveData<CityWeather>
}