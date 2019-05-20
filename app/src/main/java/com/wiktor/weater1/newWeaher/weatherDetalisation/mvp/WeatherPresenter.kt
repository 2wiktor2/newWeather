package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.wiktor.weater1.newWeaher.cityList.model.CityModel
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*

@InjectViewState
class WeatherPresenter : MvpPresenter<WeatherView>() {

    var disp: Disposable? = null

    internal var model: WeatherContract.Model = WeatherModel()

    fun start(cityModel: CityModel) {
        viewState.changeTitle(cityModel)

        val forecastWeatherCall = model.getForecastWeather(cityModel.nameForQuery, 7)
        val myObserver: Observer<WeatherForecastResponse>
        myObserver = object : Observer<WeatherForecastResponse> {
            override fun onSubscribe(d: Disposable) {
                disp = d
            }

            override fun onNext(weatherForecastResponse: WeatherForecastResponse) {
                val t = weatherForecastResponse.current?.let { it.tempC ?: "xx,x" }
                viewState.showData(t as Double)

                val newList = ArrayList<WeatherModelForView>()
                val size: Int = weatherForecastResponse.forecast?.forecastday?.size ?: 7
                for (i in 0 until size) {
                    val forecastDay = weatherForecastResponse.forecast?.forecastday?.get(i)

                    var url = forecastDay?.day?.condition?.icon
                    url?.startsWith("//").let { url = "http:$url" }


                    val model = url?.let { myUrl ->
                        WeatherModelForView(
                                forecastDay?.date ?: "_",
                                forecastDay?.day?.let { it.maxtempC ?: 00.0 },
                                forecastDay?.day?.let { it.mintempC ?: 00.0 },
                                myUrl
                        )
                    }
                    model?.let { newList.add(it) }
                }

                viewState.hideProgressBar()
                viewState.showList(newList)
            }

            override fun onError(e: Throwable) {
                e.message?.let { viewState.showErrorDialog(it) }
            }

            override fun onComplete() {

            }
        }
        forecastWeatherCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myObserver)
    }

    fun pause() {
        disp?.dispose()
    }
}

