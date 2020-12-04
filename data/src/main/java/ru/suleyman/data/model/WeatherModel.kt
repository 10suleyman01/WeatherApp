package ru.suleyman.data.model

data class WeatherModel(
    val coord: Coord? = null,
    val weather: List<Weather>? = null,
    val base: String? = null,
    val main: Main? = null,
    val visibility: Int? = 0,
    val wind: Wind? = null,
    val clouds: Clouds? = null,
    val dt: Long? = 0,
    val sys: Sys? = null,
    val timezone: Long? = 0,
    val id: Long? = 0,
    val name: String? = null,
    val cod: Int){

    data class Coord(val lan: Double, val lat: Double) {
        override fun toString(): String {
            return "Coord(lan=$lan, lat=$lat)"
        }
    }

    data class Weather(
        val id: Long,
        val main: String,
        val description: String,
        val icon: String) {
        override fun toString(): String {
            return "Weather(id=$id, main='$main', description='$description', icon='$icon')"
        }

        fun description() : String {
            return when (main) {
                "Thunderstorm" -> when(description) {
                    else -> ""
                }
                "Drizzle" -> when(description) {
                    else -> ""
                }
                "Clouds" -> when(description) {
                    "few clouds" -> ""
                    "scattered clouds" -> ""
                    "broken clouds" -> ""
                    "overcast clouds" -> ""
                    else -> ""
                }
                "Rain" -> when(description) {
                    else -> ""
                }
                "Clear" -> when(description) {
                    else -> "Чистое небо"
                }
                "Snow" -> when(description) {
                 "light snow" -> "Небольшой снег"
                 "Snow" -> "Снег"
                 "Heavy snow" -> "Снегопад"
                 "Sleet" -> "Мокрый снег"
                 "Light shower sleet" -> "Дождь со снегом"
                 "Shower sleet" -> "Дождливо"
                 "Light rain and snow" -> "Небольшой дождь со снегом"
                 "Rain and snow" -> "Дождь и снег"
                 "Light shower snow" -> "Легкий снегопад"
                 "Shower snow" -> "Ливнеь со снегом"
                 "Heavy shower snow" -> "Сильный снегопад"
                 else -> ""
                }

                else -> ""
            }
        }
    }

    data class Main(
        val temp: Double,
        val feels_like: Double,
        val temp_min: Double,
        val temp_max: Double,
        val pressure: Int,
        val humidity: Int) {
        override fun toString(): String {
            return "Main(temp=$temp, feels_like=$feels_like, temp_min=$temp_min, temp_max=$temp_max, pressure=$pressure, humidity=$humidity)"
        }
    }

    data class Wind(
        val speed: Double,
        val deg: Double,
    ) {
        override fun toString(): String {
            return "Wind(speed=$speed, deg=$deg)"
        }
    }

    data class Clouds(val all: Int)

    data class Sys(
        val type: Int,
        val id: Int,
        val message: Int,
        val country: String,
        val sunrise: Int,
        val sunset: Int, ) {
        override fun toString(): String {
            return "Sys(type=$type, id=$id, message=$message, country=$country, sunrise=$sunrise, sunset=$sunset)"
        }
    }

    override fun toString(): String {
        return "WeatherModel(coord=$coord, weather=$weather, base=$base, main=$main, visibility=$visibility, wind=$wind, clouds=$clouds, dt=$dt, sys=$sys, timezone=$timezone, id=$id, name=$name, cod=$cod)"
    }
}