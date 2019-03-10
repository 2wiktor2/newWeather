package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp;

import com.wiktor.weater1.newWeaher.weatherDetalisation.network.ApiWeather;
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.NetworkHelper;

import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class WeatherModel implements WeatherContract.Model {

    private ApiWeather apiWeather;

    public WeatherModel() {
        Retrofit myRetrofit = NetworkHelper.getRetrofit();
        apiWeather = myRetrofit.create(ApiWeather.class);
    }

    @Override
    public Call<WeatherForecastResponse> getForecastWeather( String city, int days) {
        return apiWeather.getForecastWeather(NetworkHelper.KEY, city , days);
    }


}
