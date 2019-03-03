package com.example.weatherapp.view

import android.app.ActivityOptions
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityEnterLocationBinding
import com.example.weatherapp.handlers.Handler
import com.example.weatherapp.model.CityWeather
import com.example.weatherapp.viewmodel.ViewModelFactory
import com.example.weatherapp.viewmodel.WeatherViewModel

class EnterLocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var activityMainBinding: ActivityEnterLocationBinding
        activityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_enter_location
        )

        var viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(WeatherViewModel::class.java)
        viewModel.getWeatherResultData().observe(this, Observer {
            onSuccess(it)
        })

        activityMainBinding.model = viewModel

        activityMainBinding!!.handler = object : Handler {
            override fun getWeatherLocation() {
                var latitude = activityMainBinding.latitude.text.toString()
                var longitude = activityMainBinding.longitude.text.toString()
                viewModel.getWeatherLocation(latitude, longitude)
            }

            override fun getWeatherCity() {
                var city = activityMainBinding.city.text.toString()
                viewModel.getWeatherCity(city)
            }
        }
    }

    private fun onSuccess(cityWeather: CityWeather?) {
        Toast.makeText(this, "retrieved weather for ${cityWeather?.city}", Toast.LENGTH_SHORT).show()

        val intent = Intent(this@EnterLocationActivity, DetailedWeatherActivity::class.java)
        val options = ActivityOptions.makeSceneTransitionAnimation(
            this@EnterLocationActivity
        )
        intent.putExtra("city", cityWeather)
        startActivity(intent, options.toBundle())
    }
}
