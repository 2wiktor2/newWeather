package com.wiktor.weater1.newWeaher.weatherDetalisation.network

import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWeather {
    //http://api.apixu.com/v1/forecast.json?key=29905fab70f34906863212017190703&q=Moscow&days=2
    @GET("v1/forecast.json")
     fun getForecastWeather(
            @Query("key") key: String,
            @Query("q") city: String,
            @Query("days") days: Int): Observable<WeatherForecastResponse>
}
