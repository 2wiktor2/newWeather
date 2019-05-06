package com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherForecastResponse {

    @SerializedName("location")
    @Expose
    var location: Location? = null

    @SerializedName("current")
    @Expose
    var current: Current? = null

    @SerializedName("forecast")
    @Expose
    var forecast: Forecast? = null

}