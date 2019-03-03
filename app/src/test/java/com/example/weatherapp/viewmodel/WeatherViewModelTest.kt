package com.example.weatherapp.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class WeatherViewModelTest {

    private val correctLongitude = -1.07953

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()


    lateinit var viewModel: WeatherViewModel

    @Before
    fun setUp() {
        viewModel = WeatherViewModel()

    }

    @After
    fun tearDown() {
    }

    //Test1 : test a correct Longitude
    @Test
    fun testCorrectLongitude(){
        assertEquals(viewModel.validateLongitude(correctLongitude),true)
    }

    //Test2 : test a incorrect Longitude
    @Test
    fun testIncorrectLongitude(){
        assertEquals(viewModel.validateLongitude(1212.0),false)
    }

    //Test3 : test a correct Latitude
    @Test
    fun testCorrectLatitude(){
        assertEquals(viewModel.validateLatitude(-1.07953),true)
    }

    //Test4 : test a incorrect Latitude
    @Test
    fun testIncorrectLatitude(){
        assertEquals(viewModel.validateLatitude(1212.0),false)
    }

}