package com.example.weatherapp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.R
import com.example.weatherapp.model.CityWeather
import com.example.weatherapp.utils.IconProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detailed_weather.*
import kotlinx.android.synthetic.main.weather_card.*
import java.util.*

class DetailedWeatherActivity : AppCompatActivity() {
    private lateinit var cityWeather: CityWeather
    internal var namesOfDays = arrayOf("SAT", "SUN", "MON", "TUE", "WED", "THU", "FRI")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_weather)
        val bundle = intent.extras
        if (!bundle!!.isEmpty) {
            cityWeather = bundle.getSerializable("city") as CityWeather
        }

        setCardData()
    }

    private fun toCelcius(input: Float): String {
        return input.toInt().toString() + "°C"
    }

    private fun toHumidity(input: Float): String {
        return input.toInt().toString() + "%"
    }
    private fun toClouds(input: Float): String {
        return input.toInt().toString() + "%"
    }

    private fun toSpeed(input: Float): String {
        return input.toInt().toString() + " m/s"
    }

    private fun toPressure(input: Float): String {
        return input.toInt().toString() + " hPa"
    }

    private fun setCardData() {

        textViewCardCityName.text = "${cityWeather.city.name} , ${cityWeather.city.country}"
        textViewCardWeatherDescription.text = cityWeather.weeklyWeather.get(0).weatherDetails.get(0).longDescription
        textViewCardCurrentTemp.text = toCelcius(cityWeather.weeklyWeather.get(0).temp.day)
        textViewCardMaxTemp.text = toCelcius(cityWeather.weeklyWeather.get(0).temp.max)
        textViewCardMinTemp.text = toCelcius(cityWeather.weeklyWeather.get(0).temp.min)
        textViewHumidity.text = toHumidity(cityWeather.weeklyWeather.get(0).humidity)
        textViewWind.text = toSpeed(cityWeather.weeklyWeather.get(0).speed)
        textViewCloudiness.text = toHumidity(cityWeather.weeklyWeather.get(0).clouds)
        textViewPressure.text = toPressure(cityWeather.weeklyWeather.get(0).pressure)

        val weatherDescription = cityWeather.weeklyWeather.get(0).weatherDetails.get(0).shotDescription
        Picasso.with(this).load(IconProvider.getImageIcon(weatherDescription)).into(imageViewCardWeatherIcon)
        val date = Date()
        val calendar = GregorianCalendar()
        for (i in 1 until cityWeather.weeklyWeather.size) {
            calendar.time = date
            val day = namesOfDays[(calendar.get(Calendar.DAY_OF_WEEK) + i) % 7]
            val weatherWeekDescription: String

            when (i) {
                0 -> {
                    TODO("shouldn't return 0")
                }
                1 -> {
                    textViewDay1.setText(day)
                    weatherWeekDescription =
                        cityWeather.weeklyWeather.get(i).weatherDetails.get(0).shotDescription
                    Picasso.with(this).load(IconProvider.getImageIcon(weatherWeekDescription)).into(imageViewDay1)
                    textViewMaxTempDay1.text = toCelcius(cityWeather.weeklyWeather.get(i).temp.max)
                    textViewMinTempDay1.text = toCelcius(cityWeather.weeklyWeather.get(i).temp.min)
                }
                2 -> {
                    textViewDay2.setText(day)
                    weatherWeekDescription =
                        cityWeather.weeklyWeather.get(i).weatherDetails.get(0).shotDescription
                    Picasso.with(this).load(IconProvider.getImageIcon(weatherWeekDescription)).into(imageViewDay2)
                    textViewMaxTempDay2.text = toCelcius(cityWeather.weeklyWeather.get(i).temp.max)
                    textViewMinTempDay2.text = toCelcius(cityWeather.weeklyWeather.get(i).temp.min)
                }
                3 -> {
                    textViewDay3.setText(day)
                    weatherWeekDescription =
                        cityWeather.weeklyWeather.get(i).weatherDetails.get(0).shotDescription
                    Picasso.with(this).load(IconProvider.getImageIcon(weatherWeekDescription)).into(imageViewDay3)
                    textViewMaxTempDay3.text = toCelcius(cityWeather.weeklyWeather.get(i).temp.max)
                    textViewMinTempDay3.text = toCelcius(cityWeather.weeklyWeather.get(i).temp.min)
                }
                4 -> {
                    textViewDay4.setText(day)
                    weatherWeekDescription =
                        cityWeather.weeklyWeather.get(i).weatherDetails.get(0).shotDescription
                    Picasso.with(this).load(IconProvider.getImageIcon(weatherWeekDescription)).into(imageViewDay4)
                    textViewMaxTempDay4.text = toCelcius(cityWeather.weeklyWeather.get(i).temp.max)
                    textViewMinTempDay4.text = toCelcius(cityWeather.weeklyWeather.get(i).temp.min)
                }
                5 -> {
                    textViewDay5.setText(day)
                    weatherWeekDescription =
                        cityWeather.weeklyWeather.get(i).weatherDetails.get(0).shotDescription
                    Picasso.with(this).load(IconProvider.getImageIcon(weatherWeekDescription)).into(imageViewDay5)
                    textViewMaxTempDay5.text = toCelcius(cityWeather.weeklyWeather.get(i).temp.max)
                    textViewMinTempDay5.text = toCelcius(cityWeather.weeklyWeather.get(i).temp.min)
                }
                else -> {
                }
            }

        }

    }
}
