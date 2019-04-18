package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp;

import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse;

import retrofit2.Call;

public interface WeatherContract {
    interface Model {
        Call <WeatherForecastResponse> getForecastWeather(String city, int days);
    }
}
