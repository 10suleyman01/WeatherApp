package ru.suleyman.data.remote.provider

import kotlinx.coroutines.Deferred
import ru.suleyman.data.model.WeatherModel
import ru.suleyman.data.remote.factory.WeatherFactory

object WeatherProvider {

    suspend fun getWeather(): WeatherModel {
        return WeatherFactory.getWeatherService().weather("Сургут").await()
    }

}