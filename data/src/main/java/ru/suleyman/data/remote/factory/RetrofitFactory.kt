package ru.suleyman.data.remote.factory

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    fun provide(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpFactory.provide())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun provideWeatherApi(): Retrofit {
        return provide("https://api.openweathermap.org/data/2.5/")
    }
}