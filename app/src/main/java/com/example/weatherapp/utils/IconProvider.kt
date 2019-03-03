package com.example.weatherapp.utils

import com.example.weatherapp.R

object IconProvider {

    fun getImageIcon(weatherDescription: String): Int {
        val weatherIcon: Int
        when (weatherDescription) {
            "Thunderstorm" -> weatherIcon = R.mipmap.ic_atmosphere
            "Drizzle" -> weatherIcon = R.mipmap.ic_drizzle
            "Rain" -> weatherIcon = R.mipmap.ic_rain
            "Snow" -> weatherIcon = R.mipmap.ic_snow
            "Atmosphere" -> weatherIcon = R.mipmap.ic_atmosphere
            "Clear" -> weatherIcon = R.mipmap.ic_clear
            "Clouds" -> weatherIcon = R.mipmap.ic_cloudy
            "Extreme" -> weatherIcon = R.mipmap.ic_extreme
            else -> weatherIcon = R.mipmap.ic_launcher
        }
        return weatherIcon
    }
}
