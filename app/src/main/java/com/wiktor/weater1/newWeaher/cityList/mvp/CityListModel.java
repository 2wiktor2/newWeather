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
        listCities.add(new CityModel("Нью-Йорк", "new-york"));
        listCities.add(new CityModel("Милан", "milan"));
        listCities.add(new CityModel("Рим", "rome"));
        listCities.add(new CityModel("Каир", "Cairo"));
        listCities.add(new CityModel("Минск", "Minsk"));
        listCities.add(new CityModel("Стокгольм", "Stockholm"));
        listCities.add(new CityModel("Рейкьявик", "Reykjavik"));
        listCities.add(new CityModel("Крайстчерч", "Christchurch"));
        listCities.add(new CityModel("Кейптаун", "Cape Town"));
        listCities.add(new CityModel("Гавана", "Habana"));
        listCities.add(new CityModel("Рио-де-Жанейро", "Rio de Janeiro"));
    }

    @Override
    public List<CityModel> getListOfCities() {
        return listCities;
    }
}
