package com.wiktor.weater1.newWeaher.cityList.adapter

import com.wiktor.weater1.newWeaher.cityList.mvp.CityListModel

interface ClickInterfaceKt {
    fun click(model: CityListModel): Unit
}