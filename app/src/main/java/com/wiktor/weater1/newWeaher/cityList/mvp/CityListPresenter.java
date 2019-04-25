package com.wiktor.weater1.newWeaher.cityList.mvp;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.wiktor.weater1.newWeaher.cityList.model.CityModel;

import java.util.List;


@InjectViewState
public class CityListPresenter extends MvpPresenter <CityListView> {

    Model model = new CityListModel();

    public void start() {
        List <CityModel> list = model.getListOfCities();
        getViewState().showCityList(list);

    }
}
