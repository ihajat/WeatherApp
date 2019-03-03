package com.example.weatherapp.network;

import com.example.weatherapp.model.CityWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherServices {
    @GET("forecast/daily")
    Call<CityWeather> getWeatherCity(@Query("q") String city, @Query("APPID") String key, @Query("units") String units, @Query("cnt") int days);

    @GET("forecast/daily")
    Call<CityWeather> getWeatherLocation(@Query("lat") String lat, @Query("lon") String lon, @Query("APPID") String key, @Query("units") String units, @Query("cnt") int days);

}
