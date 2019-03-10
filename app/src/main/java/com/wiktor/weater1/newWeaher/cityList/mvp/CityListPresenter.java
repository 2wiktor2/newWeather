package com.wiktor.weater1.newWeaher.cityList.mvp;

import com.wiktor.weater1.newWeaher.cityList.model.CityModel;

import java.util.List;

public class CityListPresenter implements CityListContract.Presenter {

    CityListContract.View view;

    CityListContract.Model model = new CityListModel();


    public CityListPresenter(CityListContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        List<CityModel> list = model.getListOfCities();
        view.showCityList(list);

    }
}
