package com.example.weatherapp.repository

import android.arch.lifecycle.MutableLiveData
import com.example.weatherapp.model.CityWeather
import com.example.weatherapp.network.WeatherServices
import com.example.weatherapp.utils.KEY
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository: Repository, BaseRepository() {

    @Inject
    lateinit var apiService: WeatherServices

    var resultData = MutableLiveData<CityWeather>()

    override fun getWeatherResultData(): MutableLiveData<CityWeather> {
        return resultData
    }

    override fun getWeatherCity(_city: String) {
        val loginCall = apiService.getWeatherCity(_city, KEY, "metric", 6)

        loginCall.enqueue(object: retrofit2.Callback<CityWeather>{
            override fun onFailure(call: Call<CityWeather>, t: Throwable) {
                TODO("not implemented")
            }

            override fun onResponse(call: Call<CityWeather>, response: Response<CityWeather>) {
                resultData.value=response.body()
            }
        })
    }

    override fun getWeatherLocation(_latitute: String, _longitude: String) {
        val loginCall = apiService.getWeatherLocation(_latitute, _longitude, KEY, "metric", 6)

        loginCall.enqueue(object: retrofit2.Callback<CityWeather>{
            override fun onFailure(call: Call<CityWeather>, t: Throwable) {
                TODO("not implemented")
            }

            override fun onResponse(call: Call<CityWeather>, response: Response<CityWeather>) {
                resultData.value=response.body()

            }
        })
    }
}