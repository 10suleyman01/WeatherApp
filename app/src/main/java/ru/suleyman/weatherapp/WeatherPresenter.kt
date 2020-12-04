package ru.suleyman.weatherapp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.suleyman.domain.repository.WeatherRepository

@InjectViewState
class WeatherPresenter: MvpPresenter<WeatherView>() {

    override fun attachView(view: WeatherView?) {
        super.attachView(view)
        loadWeather()
    }

    fun loadWeather() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val weather = WeatherRepository.fetchWeather()
                withContext(Dispatchers.Main) {
                    viewState.loadWeather(weather)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}