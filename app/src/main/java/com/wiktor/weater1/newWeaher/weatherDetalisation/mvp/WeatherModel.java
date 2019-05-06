package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp;


import android.support.annotation.NonNull;

import com.wiktor.weater1.newWeaher.weatherDetalisation.network.ApiWeather;
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.NetworkHelper;
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse;

import retrofit2.Call;
import retrofit2.Retrofit;

public class WeatherModel implements WeatherContract.Model {

    private ApiWeather apiWeather;

    public WeatherModel() {
        Retrofit myRetrofit = NetworkHelper.INSTANCE.getRetrofit();
        apiWeather = myRetrofit.create(ApiWeather.class);
    }

    @NonNull
    @Override
    public Call<WeatherForecastResponse> getForecastWeather(String city, int days) {
        return apiWeather.getForecastWeather(NetworkHelper.INSTANCE.getKEY(), city, days);
    }
}

