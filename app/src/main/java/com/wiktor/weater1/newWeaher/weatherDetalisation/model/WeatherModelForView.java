package com.wiktor.weater1.newWeaher.weatherDetalisation.model;

public class WeatherModelForView {
    String date;
    Double maxTemperature;
    Double minTemperature;
    String imageUrl;

    public WeatherModelForView(String date, Double maxTemperature, Double minTemperature, String imageUrl) {
        this.date = date;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
