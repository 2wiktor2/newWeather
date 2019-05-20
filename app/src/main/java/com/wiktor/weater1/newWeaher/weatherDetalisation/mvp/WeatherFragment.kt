package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.wiktor.weater1.R
import com.wiktor.weater1.newWeaher.NewWeatherActivity
import com.wiktor.weater1.newWeaher.cityList.model.CityModel
import com.wiktor.weater1.newWeaher.weatherDetalisation.adapter.WeaverAdapter
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView
import kotlinx.android.synthetic.main.weather_detalisation_fragment.*

class WeatherFragment : MvpAppCompatFragment(), WeatherView {

    @InjectPresenter
    lateinit var presenter: WeatherPresenter
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.weather_detalisation_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val arg = arguments

        arg?.let {
            val model = arg.getSerializable(KEY_CITY_MODEL) as CityModel
            presenter.start(model)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = progress_circular
    }

    override fun onResume() {
        super.onResume()
        activity.let { (activity as NewWeatherActivity).showArrow(true) }
    }

    // отмена запросов
    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun showData(temperat: Double) {
        activity.let {
            (activity as? NewWeatherActivity)?.let { it.setMySubtitle("Сейчас: $temperat°") }
        }
    }

    override fun showErrorDialog(error: String) {
        Toast.makeText(context, "Ошибка: $error", Toast.LENGTH_SHORT).show()
    }


    override fun showList(list: List<WeatherModelForView>) {
        recycler_view_container.apply {
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
            layoutManager = LinearLayoutManager(context)
            adapter = WeaverAdapter(list)
        }
    }

    override fun changeTitle(cityModel: CityModel) {
        ((activity) as NewWeatherActivity).setMyTitle(cityModel.name)
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    companion object {

        private const val KEY_CITY_MODEL = "key_city_model"

        fun newInstance(cityModel: CityModel): WeatherFragment {
            val weatherFragment = WeatherFragment()
            val bundle = Bundle()
            bundle.putSerializable(KEY_CITY_MODEL, cityModel)
            weatherFragment.arguments = bundle
            return weatherFragment
        }
    }

}
