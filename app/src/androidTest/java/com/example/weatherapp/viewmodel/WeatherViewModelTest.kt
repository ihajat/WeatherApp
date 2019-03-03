package com.example.weatherapp.viewmodel

import org.junit.After
import org.junit.Before

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.*
import com.example.weatherapp.R
import com.example.weatherapp.view.DetailedWeatherActivity
import com.example.weatherapp.view.EnterLocationActivity
import org.junit.Rule
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class WeatherViewModelInstrumentationTest {

    @Rule
    @JvmField
    public val rule  = ActivityTestRule(EnterLocationActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    //Test1 : test the detailed activity is dislayed with a correct city
    @Test
    fun weather_successful_by_city(){
        Espresso.onView((withId(R.id.city)))
            .perform(ViewActions.typeText("london"))

        Espresso.onView(withId(R.id.submitByCity))
            .perform(ViewActions.click())

        Thread.sleep(2000L)

        intended(hasComponent(DetailedWeatherActivity::class.java!!.getName()))
    }

    //Test2 : test the detailed activity is dislayed with a correct location
    @Test
    fun weather_successful_by_location(){
        Espresso.onView((withId(R.id.latitude)))
            .perform(ViewActions.typeText("52.64003"))
        Espresso.onView((withId(R.id.longitude)))
            .perform(ViewActions.typeText("-1.07953"))

        Espresso.onView(withId(R.id.submitByLocation))
            .perform(ViewActions.click())

        Thread.sleep(2000L)

        intended(hasComponent(DetailedWeatherActivity::class.java!!.getName()))
    }
}