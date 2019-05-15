package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp

import com.wiktor.weater1.newWeaher.weatherDetalisation.network.ApiWeather
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.NetworkHelper
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse
import io.reactivex.Observable


class WeatherModel : WeatherContract.Model {

    private val apiWeather: ApiWeather

    init {
        val myRetrofit = NetworkHelper.retrofit
        apiWeather = myRetrofit.create(ApiWeather::class.java)
    }


    override fun getForecastWeather(city: String, days: Int): Observable<WeatherForecastResponse> {
        return apiWeather.getForecastWeather(NetworkHelper.KEY, city, days)
    }
}

