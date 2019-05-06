package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp

import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse
import retrofit2.Call

interface WeatherContract {
    interface Model {
        fun getForecastWeather(city: String, days: Int): Call<WeatherForecastResponse>
    }
}