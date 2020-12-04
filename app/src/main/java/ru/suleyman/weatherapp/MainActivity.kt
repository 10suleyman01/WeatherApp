package ru.suleyman.weatherapp

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.suleyman.data.model.WeatherModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.floor

class MainActivity : MvpAppCompatActivity(), WeatherView {

    lateinit var cityView: TextView
    lateinit var timeView: TextView
    lateinit var temperatureView: TextView
    lateinit var descriptionView: TextView

    @InjectPresenter
    lateinit var weatherPresenter: WeatherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityView = findViewById(R.id.cityName)
        timeView = findViewById(R.id.timeView)
        temperatureView = findViewById(R.id.temperatureView)
        descriptionView = findViewById(R.id.descriptionView)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun loadWeather(weather: WeatherModel) {
        cityView.text = weather.name
        val date = LocalDateTime.now()
        DateTimeFormatter.ofPattern("HH:mm").apply {
            timeView.text = date.format(this)
        }
        temperatureView.text = floor(weather.main?.temp!!).toInt().toString() + "℃"
        descriptionView.text = weather.weather!![0].description()
    }

}