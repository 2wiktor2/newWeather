package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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
import java.util.*

class WeatherFragment : MvpAppCompatFragment(), WeatherView {

    @InjectPresenter
    lateinit var presenter: WeatherPresenter

    private lateinit var mRecyclerView: RecyclerView
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
        if (arg != null) {
            val model = arg.getSerializable(KEY_CITY_MODEL) as CityModel
            presenter.start(model)

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar =progress_circular
        mRecyclerView = recycler_view_container
    }

    override fun onResume() {
        super.onResume()
        if (activity != null) {
            (activity as NewWeatherActivity).showArrow(true)
        }
    }

    // отмена запросов
    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun showData(temperat: Double) {
        if (activity != null) {
            (activity as NewWeatherActivity)
                    .setMySubtitle("Сейчас: $temperat°")
        }
    }

    override fun showErrorDialog(error: String) {
        Toast.makeText(context, "Ошибка: $error", Toast.LENGTH_SHORT).show()
    }

    override fun showList(list: List<WeatherModelForView>) {
        val adapter = WeaverAdapter(list)
        val layoutManager = LinearLayoutManager(context)
        mRecyclerView.addItemDecoration(DividerItemDecoration(
                Objects.requireNonNull<Context>(context), LinearLayout.VERTICAL))
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.adapter = adapter
    }

    override fun changeTitle(cityModel: CityModel) {
        (Objects.requireNonNull<FragmentActivity>(activity) as NewWeatherActivity).setMyTitle(cityModel.name)
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
