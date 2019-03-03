package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class WeatherDetails : Serializable {
    var id: Int = 0
    @SerializedName("main")
    lateinit var shotDescription: String
    @SerializedName("description")
    var longDescription: String? = null
    var icon: String? = null
}
