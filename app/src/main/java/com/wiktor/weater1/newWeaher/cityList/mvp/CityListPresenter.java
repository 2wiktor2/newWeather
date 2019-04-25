package com.wiktor.weater1.newWeaher.cityList.mvp;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.wiktor.weater1.newWeaher.cityList.model.CityModelKt;

import java.util.List;


@InjectViewState
public class CityListPresenter extends MvpPresenter <CityListView> {

    CityListContract.Model model = new CityListModel();

    public void start() {
        List <CityModelKt> list = model.getListOfCities();
        getViewState().showCityList(list);

    }
}
