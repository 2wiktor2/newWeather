package com.wiktor.weater1.newWeaher.cityList.mvp;

import com.wiktor.weater1.newWeaher.cityList.model.CityModelKt;

import java.util.List;

public interface CityListContract {

    interface Model {
        List<CityModelKt> getListOfCities();
    }
}
