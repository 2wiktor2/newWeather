package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.wiktor.weater1.newWeaher.cityList.model.CityModel;
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView;
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.Forecastday;
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@InjectViewState
public class WeatherPresenter extends MvpPresenter <WeatherView> {

    WeatherContract.Model model = new WeatherModel();

    Call <WeatherForecastResponse> forecastWeatherCall;


    public void start(CityModel cityModel) {
        getViewState().changeTitle(cityModel);
        forecastWeatherCall = model.getForecastWeather(cityModel.getNameForQuery(), 7);
        forecastWeatherCall.enqueue(new Callback <WeatherForecastResponse>() {
            @Override
            public void onResponse(Call <WeatherForecastResponse> call, Response <WeatherForecastResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null && response.body().getCurrent() != null) {
                        double t = response.body().getCurrent().getTempC();
                        getViewState().showData(t);


                        List <WeatherModelForView> newList = new ArrayList <>();
                        int size = response.body().getForecast().getForecastday().size();
                        for (int i = 0; i < size; i++) {
                            Forecastday forecastDay = response.body().getForecast().getForecastday().get(i);

                            String url = forecastDay.getDay().getCondition().getIcon();
                            if (url.startsWith("//")) {
                                url = "http:" + url;
                            }

                            WeatherModelForView model = new WeatherModelForView(
                                    forecastDay.getDate(),
                                    forecastDay.getDay().getMaxtempC(),
                                    forecastDay.getDay().getMintempC(),
                                    url);
                            newList.add(model);
                        }
                        getViewState().hideProgressBar();
                        getViewState().showList(newList);
                    }
                }
            }

            @Override
            public void onFailure(Call <WeatherForecastResponse> call, Throwable t) {
                getViewState().showErrorDialog(t.getMessage());
            }
        });

    }

    public void pause() {
        if (forecastWeatherCall != null) {
            forecastWeatherCall.cancel();
            forecastWeatherCall = null;
        }
    }

}
