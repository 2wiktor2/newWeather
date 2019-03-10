package com.wiktor.weater1.newWeaher;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wiktor.weater1.R;
import com.wiktor.weater1.newWeaher.cityList.mvp.CityListFragment;

public class NewWeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_weather);

        openCityListFragment();
    }

    private void openCityListFragment() {
        CityListFragment cityListFragment = new CityListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frame, cityListFragment);
        transaction.commit();
    }
}
