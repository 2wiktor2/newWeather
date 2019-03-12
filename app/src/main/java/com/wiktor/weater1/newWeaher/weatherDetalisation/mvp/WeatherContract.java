package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp;

import com.wiktor.weater1.newWeaher.cityList.model.CityModel;
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView;
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse;

import java.util.List;

import retrofit2.Call;

public interface WeatherContract {
    interface Model {
        Call <WeatherForecastResponse> getForecastWeather(String city, int days);
    }

    interface Presenter {
        void start(CityModel cityModel);
        void pause();
    }

    interface View {
        void showData(double temperat);

        void showErrorDialog(String error);

        void showList(List <WeatherModelForView> list);

        void changeTitle(CityModel cityModel);

    }

}
