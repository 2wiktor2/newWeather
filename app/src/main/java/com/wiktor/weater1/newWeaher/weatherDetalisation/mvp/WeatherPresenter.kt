package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.wiktor.weater1.newWeaher.cityList.model.CityModel
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

@InjectViewState
class WeatherPresenter : MvpPresenter<WeatherView>() {

    internal var model: WeatherContract.Model = WeatherModel()

    internal var forecastWeatherCall: Call<WeatherForecastResponse>? = null


    fun start(cityModel: CityModel) {
        viewState.changeTitle(cityModel)
        forecastWeatherCall = model.getForecastWeather(cityModel.nameForQuery, 7)
        forecastWeatherCall!!.enqueue(object : Callback<WeatherForecastResponse> {
            override fun onResponse(call: Call<WeatherForecastResponse>, response: Response<WeatherForecastResponse>) {
                if (response.isSuccessful) {
                    if (response.body() != null && response.body()!!.current != null) {
                        val t = response.body()!!.current!!.tempC!!
                        viewState.showData(t)


                        val newList = ArrayList<WeatherModelForView>()
                        val size = response.body()!!.forecast!!.forecastday!!.size
                        for (i in 0 until size) {
                            val forecastDay = response.body()!!.forecast!!.forecastday!![i]

                            var url = forecastDay.day!!.condition!!.icon
                            if (url!!.startsWith("//")) {
                                url = "http:$url"
                            }

                            val model = WeatherModelForView(
                                    forecastDay.date!!,
                                    forecastDay.day!!.maxtempC,
                                    forecastDay.day!!.mintempC,
                                    url)
                            newList.add(model)
                        }
                        viewState.hideProgressBar()
                        viewState.showList(newList)
                    }
                }
            }

            override fun onFailure(call: Call<WeatherForecastResponse>, t: Throwable) {
                viewState.showErrorDialog(t.message.toString())
            }
        })

    }

    fun pause() {
        if (forecastWeatherCall != null) {
            forecastWeatherCall!!.cancel()
            forecastWeatherCall = null
        }
    }

}
