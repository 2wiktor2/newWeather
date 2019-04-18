package com.wiktor.weater1.newWeaher.cityList.mvp;

import com.wiktor.weater1.newWeaher.cityList.model.CityModel;

import java.util.List;

public interface CityListContract {

    interface Model {
        List<CityModel> getListOfCities();
    }
}
