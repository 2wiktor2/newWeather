package com.wiktor.weater1.newWeaher.cityList.mvp;

import com.wiktor.weater1.newWeaher.cityList.model.CityModelKt;

import java.util.ArrayList;
import java.util.List;

public class CityListModel implements CityListContract.Model {

    ArrayList<CityModelKt> listCities;

    @Override
    public List<CityModelKt> getListOfCities() {
        return listCities;
    }

    public CityListModel() {
        listCities = new ArrayList<>();
        listCities.add(new CityModelKt("Москва", "Moscow"));
        listCities.add(new CityModelKt("Париж", "Paris"));
        listCities.add(new CityModelKt("Лондон", "London"));
        listCities.add(new CityModelKt("Нью-Йорк", "new-york"));
        listCities.add(new CityModelKt("Милан", "milan"));
        listCities.add(new CityModelKt("Рим", "rome"));
        listCities.add(new CityModelKt("Каир", "Cairo"));
        listCities.add(new CityModelKt("Минск", "Minsk"));
        listCities.add(new CityModelKt("Стокгольм", "Stockholm"));
        listCities.add(new CityModelKt("Рейкьявик", "Reykjavik"));
        listCities.add(new CityModelKt("Крайстчерч", "Christchurch"));
        listCities.add(new CityModelKt("Кейптаун", "Cape Town"));
        listCities.add(new CityModelKt("Гавана", "Habana"));
        listCities.add(new CityModelKt("Рио-де-Жанейро", "Rio de Janeiro"));
        // запрос работает с русскими названияи
        listCities.add(new CityModelKt("Архангельск", "Архангельск"));
    }
}
