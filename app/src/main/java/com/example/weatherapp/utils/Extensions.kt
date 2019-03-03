package com.example.weatherapp.utils

fun Float.formatSpeed(): String = this.toInt().toString() + " m/s"
fun Float.formatCelcius(): String = this.toInt().toString() + "°C"
fun Float.formatHumidity(): String = this.toInt().toString() + "%"
fun Float.formatClouds(): String = this.toInt().toString() + "%"
fun Float.formatPressure(): String = this.toInt().toString() + " hPa"
