package com.wiktor.weater1.newWeaher.cityList.model;

import java.io.Serializable;

public class CityModel implements Serializable {

    private String nameForQuery;
    private String name;

    public CityModel(String name, String nameForQuery) {
        this.name = name;
        this.nameForQuery = nameForQuery;
    }

    public String getName() {
        return name;
    }

    public String getNameForQuery() {
        return nameForQuery;
    }
}
