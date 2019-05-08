package com.wiktor.weater1.newWeaher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.wiktor.weater1.R
import com.wiktor.weater1.newWeaher.cityList.mvp.CityListFragment
import kotlinx.android.synthetic.main.toolbar.*

class NewWeatherActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_weather)

        toolbar = main_toolbar
        setSupportActionBar(toolbar)
        openCityListFragment()
    }


    private fun openCityListFragment() {
        val cityListFragment = CityListFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame, cityListFragment)
        transaction.commit()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


    fun setMyTitle(title: String) {
        toolbar.title = title
    }

    fun setMySubtitle(subtitle: String) {
        toolbar.subtitle = subtitle
    }

    fun showArrow(show: Boolean) {
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(show)
            supportActionBar!!.setDisplayShowHomeEnabled(show)
        }
    }
}
