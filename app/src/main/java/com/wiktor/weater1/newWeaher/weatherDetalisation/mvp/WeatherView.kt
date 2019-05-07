package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.wiktor.weater1.newWeaher.cityList.model.CityModel
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView

interface WeatherView : MvpView {

    @StateStrategyType(AddToEndStrategy::class)
    fun showData(temperat: Double)

    @StateStrategyType(AddToEndStrategy::class)
    fun showErrorDialog(error: String)

    @StateStrategyType(AddToEndStrategy::class)
    fun showList(list: List<WeatherModelForView>)

    @StateStrategyType(AddToEndStrategy::class)
    fun changeTitle(cityModel: CityModel)

    @StateStrategyType(AddToEndStrategy::class)
    fun hideProgressBar()
}