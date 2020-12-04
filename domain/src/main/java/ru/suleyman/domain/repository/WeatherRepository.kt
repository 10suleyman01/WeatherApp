package ru.suleyman.domain.repository

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import ru.suleyman.data.model.WeatherModel
import ru.suleyman.data.remote.provider.WeatherProvider
import java.lang.Exception

object WeatherRepository {

    suspend fun fetchWeather(): WeatherModel {
        return try {
            val weather = WeatherProvider.getWeather()
            GlobalScope.async { weather }
        } catch (e: Exception) {
            GlobalScope.async { error(e) }
        }.await()
    }

}