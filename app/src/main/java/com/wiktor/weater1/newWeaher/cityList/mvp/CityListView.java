package com.wiktor.weater1.newWeaher.cityList.mvp;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.wiktor.weater1.newWeaher.cityList.model.CityModel;

import java.util.List;

public interface CityListView extends MvpView {

    @StateStrategyType(AddToEndStrategy.class)
    void showCityList(List <CityModel> list);
}
