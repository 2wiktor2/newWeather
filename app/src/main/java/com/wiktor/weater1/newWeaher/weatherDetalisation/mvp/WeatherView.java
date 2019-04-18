package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.wiktor.weater1.newWeaher.cityList.model.CityModel;
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView;

import java.util.List;

public interface WeatherView extends MvpView {

    @StateStrategyType(AddToEndStrategy.class)
    void showData(double temperat);

    @StateStrategyType(AddToEndStrategy.class)
    void showErrorDialog(String error);

    @StateStrategyType(AddToEndStrategy.class)
    void showList(List <WeatherModelForView> list);

    @StateStrategyType(AddToEndStrategy.class)
    void changeTitle(CityModel cityModel);

    @StateStrategyType(AddToEndStrategy.class)
    void hideProgressBar();
}
