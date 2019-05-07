package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp

import com.wiktor.weater1.newWeaher.weatherDetalisation.network.ApiWeather
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.NetworkHelper
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse
import retrofit2.Call


class WeatherModel : WeatherContract.Model {

    private val apiWeather: ApiWeather

    init {
        val myRetrofit = NetworkHelper.retrofit
        apiWeather = myRetrofit.create(ApiWeather::class.java)
    }

    override fun getForecastWeather(city: String, days: Int): Call<WeatherForecastResponse> {
        return apiWeather.getForecastWeather(NetworkHelper.KEY, city, days)
    }
}

