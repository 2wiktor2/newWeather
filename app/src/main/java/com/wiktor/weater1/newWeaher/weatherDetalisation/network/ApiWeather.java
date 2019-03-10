package com.wiktor.weater1.newWeaher.weatherDetalisation.network;

import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiWeather {


    //http://api.apixu.com/v1/forecast.json?key=29905fab70f34906863212017190703&q=Moscow&days=2
    @GET("v1/forecast.json")
    Call<WeatherForecastResponse> getForecastWeather (
            @Query("key") String key,
            @Query("q") String city,
            @Query("days") int days);
}