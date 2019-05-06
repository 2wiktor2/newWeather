package com.wiktor.weater1.newWeaher.weatherDetalisation.model

class WeatherModelForView(date: String, maxTemperature: Double?, minTemperature: Double?, imageUrl: String) {
    var date: String
        internal set
    var maxTemperature: Double? = null
        internal set
    var minTemperature: Double? = null
        internal set
    var imageUrl: String
        internal set

    init {
        this.date = date
        this.maxTemperature = maxTemperature
        this.minTemperature = minTemperature
        this.imageUrl = imageUrl
    }
}