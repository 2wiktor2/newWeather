package com.wiktor.weater1.newWeaher.cityList.mvp;

import com.wiktor.weater1.newWeaher.cityList.model.CityModel;

import java.util.ArrayList;
import java.util.List;

public class CityListModel implements CityListContract.Model {

    ArrayList<CityModel> listCities;

    public CityListModel() {
        listCities = new ArrayList<>();
        listCities.add(new CityModel("Москва", "Moscow"));
        listCities.add(new CityModel("Париж", "Paris"));
        listCities.add(new CityModel("Лондон", "London"));
    }

    @Override
    public List<CityModel> getListOfCities() {
        return listCities;
    }
}
