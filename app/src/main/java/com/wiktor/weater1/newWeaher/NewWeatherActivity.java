package com.wiktor.weater1.newWeaher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.wiktor.weater1.R;
import com.wiktor.weater1.newWeaher.cityList.mvp.CityListFragment;

import java.util.List;
import java.util.Objects;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewWeatherActivity extends AppCompatActivity {

    @BindView(R.id.main_toolbar)
    Toolbar toolbar;
    @BindString(R.string.toolbar_title)
    String toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_weather);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        openCityListFragment();

    }

    private void openCityListFragment() {
        CityListFragment cityListFragment = new CityListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frame, cityListFragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setMyTitle(String title) {
        toolbar.setTitle(title);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(checkShowArrow());
    }

    public void setMySubtitle(String subtitle) {
        toolbar.setSubtitle(subtitle);

    }

/*    public void showArrow(boolean show) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(show);
            getSupportActionBar().setDisplayShowHomeEnabled(show);
        }
    }*/

    public boolean checkShowArrow() {
        List <Fragment> list = getSupportFragmentManager().getFragments();
        Log.d("Mytag2", " list: " + list.size());
        return getSupportFragmentManager().getFragments().size() > 1;
    }
}
