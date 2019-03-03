package com.example.weatherapp.viewmodel

import java.text.DecimalFormat

class WeatherViewModel {
    private val LONGITUDE_PATTERN = "^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$"
    private val df = DecimalFormat("#.######")

    fun validateLongitude(longitudeToTest: Double ): Boolean {
        try{
            return df.format(longitudeToTest).matches(LONGITUDE_PATTERN.toRegex())
        }
        catch (ex: IllegalArgumentException ){
            return false
        }
        return false
    }


}