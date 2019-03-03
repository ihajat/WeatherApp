package com.example.weatherapp.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import com.example.weatherapp.model.City
import com.example.weatherapp.model.CityWeather
import com.example.weatherapp.repository.Repository
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WeatherViewModelTest {
//    @get:Rule
//    val mockitoRule = MockitoJUnit.rule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val cityName = "Leicester"
    private val correctLongitude = -1.07953
    private val incorrectLongitude = 1212.0
    private val correctLatitude = 52.64003
    private val incorrectLatitude = 1212.0

    @Mock
    lateinit var repository: Repository

    lateinit var viewModel: WeatherViewModel

    @Before
    fun setUp() {
        viewModel = WeatherViewModel(repository)
    }

    @After
    fun tearDown() {
    }

    // Test1 : test a correct Longitude
    @Test
    fun testCorrectLongitude() {
        assertEquals(viewModel.validateLongitude(correctLongitude), true)
    }

    // Test2 : test a incorrect Longitude
    @Test
    fun testIncorrectLongitude() {
        assertEquals(viewModel.validateLongitude(incorrectLongitude), false)
    }

    // Test3 : test a correct Latitude
    @Test
    fun testCorrectLatitude() {
        assertEquals(viewModel.validateLatitude(correctLongitude), true)
    }

    // Test4 : test a incorrect Latitude
    @Test
    fun testIncorrectLatitude() {
        assertEquals(viewModel.validateLatitude(incorrectLongitude), false)
    }

    // Test5 : test a correct city is returned for the correct responding Longitude & Latitude
    @Test
    fun testDisplaysLeicesterWeatherForGivenLongitudeLatitude() {

        val testData = CityWeather()
        val cityData = City()
        cityData.name = cityName
        cityData.country = "GB"
        testData.city = cityData

        val resultData = MutableLiveData<CityWeather>()
        resultData.postValue(testData)

        Mockito.`when`(repository.getWeatherResultData()).thenReturn(resultData)

        viewModel.getWeatherLocation(correctLatitude, correctLongitude)
        assertEquals(cityName, viewModel.getWeatherResultData().value?.city?.name)
    }

    // Test6 : test a correct city is returned for the correct responding Longitude & Latitude
    @Test
    fun testDisplaysLeicesterWeatherForGivenCityName() {

        val testData = CityWeather()
        val cityData = City()
        cityData.name = cityName
        cityData.country = "GB"
        testData.city = cityData

        val resultData = MutableLiveData<CityWeather>()
        resultData.postValue(testData)

        Mockito.`when`(repository.getWeatherResultData()).thenReturn(resultData)

        viewModel.getWeatherCity(cityName)
        assertEquals(cityName, viewModel.getWeatherResultData().value?.city?.name)
    }
}