package ru.suleyman.data.remote.factory

import ru.suleyman.data.service.WeatherService

object WeatherFactory {

    fun getWeatherService(): WeatherService {
        return RetrofitFactory.provideWeatherApi().create(WeatherService::class.java)
    }

}