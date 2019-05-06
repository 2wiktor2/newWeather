package com.wiktor.weater1.newWeaher.cityList.mvp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.wiktor.weater1.newWeaher.cityList.model.CityModel


interface CityListView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCityList(list: List<CityModel>)
}

