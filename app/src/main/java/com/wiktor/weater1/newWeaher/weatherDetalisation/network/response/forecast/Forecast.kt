package com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Forecast {
    @SerializedName("forecastday")
    @Expose
    var forecastday: List<Forecastday>? = null

}