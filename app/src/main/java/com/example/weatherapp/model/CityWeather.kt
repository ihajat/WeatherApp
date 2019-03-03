package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable


class CityWeather : Serializable {
    lateinit var city: City
    @SerializedName("list")
    lateinit var weeklyWeather: List<Weather>
}


