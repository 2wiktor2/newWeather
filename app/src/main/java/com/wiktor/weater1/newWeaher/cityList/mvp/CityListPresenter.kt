package com.wiktor.weater1.newWeaher.cityList.mvp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class CityListPresenter : MvpPresenter<CityListView>() {

    internal var model: Model = CityListModel()

    fun start() {
        val list = model.getListOfCities()
        viewState.showCityList(list)
    }
}
