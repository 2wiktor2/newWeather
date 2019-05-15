package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.wiktor.weater1.newWeaher.cityList.model.CityModel
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView
import com.wiktor.weater1.newWeaher.weatherDetalisation.network.response.forecast.WeatherForecastResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*

@InjectViewState
class WeatherPresenter : MvpPresenter<WeatherView>() {

    internal var model: WeatherContract.Model = WeatherModel()

    internal var forecastWeatherCall: Observable<WeatherForecastResponse>? = null


    fun start(cityModel: CityModel) {
        viewState.changeTitle(cityModel)

        val forecastWeatherCall = model.getForecastWeather(cityModel.nameForQuery, 7)
        val myObserver = object : Observer<WeatherForecastResponse> {
            override fun onSubscribe(d: Disposable) {}

            override fun onNext(weatherForecastResponse: WeatherForecastResponse) {
                val t = weatherForecastResponse.current!!.tempC!!
                viewState.showData(t)

                val newList = ArrayList<WeatherModelForView>()
                val size = weatherForecastResponse.forecast!!.forecastday!!.size
                for (i in 0 until size) {
                    val forecastDay = weatherForecastResponse.forecast!!.forecastday!![i]

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

            override fun onError(e: Throwable) {
                e.message?.let { viewState.showErrorDialog(it) }
            }

            override fun onComplete() {

            }
        }

        forecastWeatherCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myObserver)

/*        forecastWeatherCall = model.getForecastWeather(cityModel.nameForQuery, 7)
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
        })*/

    }

    fun pause() {
/*        if (forecastWeatherCall != null) {
            forecastWeatherCall!!.cancel()
            forecastWeatherCall = null*/
        }
    }

