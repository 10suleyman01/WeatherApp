package ru.suleyman.weatherapp

import com.arellomobile.mvp.MvpView
import ru.suleyman.data.model.WeatherModel

interface WeatherView: MvpView {

    fun loadWeather(weather: WeatherModel)

}