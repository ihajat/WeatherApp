package com.example.weatherapp.model

import java.io.Serializable

class Temp : Serializable {
    var day: Float = 0.toFloat()
    var min: Float = 0.toFloat()
    var max: Float = 0.toFloat()
    var night: Float = 0.toFloat()
    var eve: Float = 0.toFloat()
    var morn: Float = 0.toFloat()
}
