package com.wiktor.weater1.newWeaher.cityList.mvp

import com.wiktor.weater1.newWeaher.cityList.model.CityModel

interface Model {
     fun getListOfCities(): List<CityModel>
}