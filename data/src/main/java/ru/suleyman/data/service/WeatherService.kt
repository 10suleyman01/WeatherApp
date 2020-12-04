package ru.suleyman.data.service

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import ru.suleyman.data.model.WeatherModel

interface WeatherService {

    @GET("weather")
    fun weather(@Query("q") city: String,
                @Query("units") units: String? = "metric",
                @Query("appid") appid: String? = "67ddfa848606d6ada7f7a480a990b74a"): Deferred<WeatherModel>
}