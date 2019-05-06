package com.wiktor.weater1.newWeaher.cityList.mvp

import com.wiktor.weater1.newWeaher.cityList.model.CityModel
import java.util.*


class CityListModel : Model {

    internal var listCities: ArrayList<CityModel> = ArrayList()

    override fun getListOfCities(): List<CityModel> {
        return listCities
    }

    init {
        listCities.add(CityModel("Москва", "Moscow"))
        listCities.add(CityModel("Париж", "Paris"))
        listCities.add(CityModel("Лондон", "London"))
        listCities.add(CityModel("Нью-Йорк", "new-york"))
        listCities.add(CityModel("Милан", "milan"))
        listCities.add(CityModel("Рим", "rome"))
        listCities.add(CityModel("Каир", "Cairo"))
        listCities.add(CityModel("Минск", "Minsk"))
        listCities.add(CityModel("Стокгольм", "Stockholm"))
        listCities.add(CityModel("Рейкьявик", "Reykjavik"))
        listCities.add(CityModel("Крайстчерч", "Christchurch"))
        listCities.add(CityModel("Кейптаун", "Cape Town"))
        listCities.add(CityModel("Гавана", "Habana"))
        listCities.add(CityModel("Рио-де-Жанейро", "Rio de Janeiro"))
        // запрос работает с русскими названияи
        listCities.add(CityModel("Архангельск", "Архангельск"))
    }
}
