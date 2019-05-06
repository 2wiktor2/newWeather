package com.wiktor.weater1.newWeaher.cityList.mvp

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindString
import butterknife.ButterKnife
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.wiktor.weater1.R
import com.wiktor.weater1.newWeaher.NewWeatherActivity
import com.wiktor.weater1.newWeaher.cityList.adapter.CityListAdapter
import com.wiktor.weater1.newWeaher.cityList.adapter.ClickInterface
import com.wiktor.weater1.newWeaher.cityList.model.CityModel
import com.wiktor.weater1.newWeaher.weatherDetalisation.mvp.WeatherFragment


class CityListFragment : MvpAppCompatFragment(), CityListView, ClickInterface {

    @InjectPresenter
    internal var presenter: CityListPresenter? = null
    internal lateinit var recyclerView: RecyclerView
    @BindString(R.string.toolbar_title)
    internal var title: String? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.city_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)

        recyclerView = getView()!!.findViewById(R.id.container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter!!.start()
    }

    override fun onResume() {
        super.onResume()
        if (activity != null) {
            (activity as NewWeatherActivity).setMyTitle(title)
            (activity as NewWeatherActivity).setMySubtitle("")
            (activity as NewWeatherActivity).showArrow(false)
        }
    }

    override fun showCityList(list: List<CityModel>) {
        val adapter = CityListAdapter(list, this)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun click(model: CityModel) {

        val weatherFragment = WeatherFragment.newInstance(model)

        val manager = fragmentManager ?: return
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frame, weatherFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
