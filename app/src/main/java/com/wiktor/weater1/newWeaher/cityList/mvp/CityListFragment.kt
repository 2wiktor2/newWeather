package com.wiktor.weater1.newWeaher.cityList.mvp

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.wiktor.weater1.R
import com.wiktor.weater1.newWeaher.NewWeatherActivity
import com.wiktor.weater1.newWeaher.cityList.adapter.CityListAdapter
import com.wiktor.weater1.newWeaher.cityList.adapter.ClickInterface
import com.wiktor.weater1.newWeaher.cityList.model.CityModel
import com.wiktor.weater1.newWeaher.weatherDetalisation.mvp.WeatherFragment
import kotlinx.android.synthetic.main.city_list_fragment.*


class CityListFragment : MvpAppCompatFragment(), CityListView, ClickInterface {

    @InjectPresenter
    lateinit var presenter: CityListPresenter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.city_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = container
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.start()


        recyclerView.setOnClickListener {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        val pp = object : View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        recyclerView.setOnClickListener { pp }
        recyclerView.setOnClickListener {

        }


    }

    override fun onResume() {
        super.onResume()
        (activity as NewWeatherActivity).apply {
            this.setMyTitle(getString(R.string.toolbar_title))
            this.setMySubtitle("")
            this.showArrow(false)
        }

/*        if (activity != null) {
            (activity as NewWeatherActivity).setMyTitle()
            (activity as NewWeatherActivity).setMySubtitle("")
            (activity as NewWeatherActivity).showArrow(false)
        }*/
    }

    override fun showCityList(list: List<CityModel>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CityListAdapter(list, this@CityListFragment)
        }

/*        val adapter = CityListAdapter(list, this)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter*/
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
