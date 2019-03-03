package com.example.weatherapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.weatherapp.model.CityWeather
import com.example.weatherapp.repository.Repository
import java.text.DecimalFormat

class WeatherViewModel(val repository: Repository) : ViewModel() {

    private val LONGITUDE_PATTERN = "^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$"
    private val LATITUDE_PATTERN = "^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$"
    private val df = DecimalFormat("#.######")

    var city = ObservableField("")
    var latitude= ObservableField("")
    var longitude= ObservableField("")

    fun getWeatherResultData(): MutableLiveData<CityWeather> {
        return repository.getWeatherResultData()
    }

    fun validateLongitude(longitudeToTest: Double ): Boolean {
        try{
            return df.format(longitudeToTest).matches(LONGITUDE_PATTERN.toRegex())
        }
        catch (ex: IllegalArgumentException ){
            return false
        }
        return false
    }

    fun validateLatitude(latitudeToTest: Double ): Boolean {
        try{
            return df.format(latitudeToTest).matches(LATITUDE_PATTERN.toRegex())
        }
        catch (ex: IllegalArgumentException ){
            return false
        }
        return false
    }

    fun getWeatherCity(_city: String) {
        city.set(_city)
        repository.getWeatherCity(_city)
    }

    fun getWeatherLocation( _latitute: String, _longitude: String) {
        latitude.set(_latitute)
        longitude.set(_longitude)
        repository.getWeatherLocation(_latitute,_longitude)
    }
}