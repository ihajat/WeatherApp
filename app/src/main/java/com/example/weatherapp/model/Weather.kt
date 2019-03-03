package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class Weather : Serializable {
    @SerializedName("dt")
    var date: Int = 0
    lateinit var temp: Temp
    var pressure: Float = 0.toFloat()
    var humidity: Float = 0.toFloat()
    @SerializedName("weather")
    lateinit var weatherDetails: List<WeatherDetails>
    var speed: Float = 0.toFloat()
    var deg: Float = 0.toFloat()
    var clouds: Float = 0.toFloat()
    var rain: Float = 0.toFloat()
}
