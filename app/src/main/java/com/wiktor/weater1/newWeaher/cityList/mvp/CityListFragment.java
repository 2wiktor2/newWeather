package com.wiktor.weater1.newWeaher.cityList.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.wiktor.weater1.R;
import com.wiktor.weater1.newWeaher.NewWeatherActivity;
import com.wiktor.weater1.newWeaher.cityList.adapter.CityListAdapter;
import com.wiktor.weater1.newWeaher.cityList.adapter.ClickInterfaceKt;
import com.wiktor.weater1.newWeaher.cityList.model.CityModelKt;
import com.wiktor.weater1.newWeaher.weatherDetalisation.mvp.WeatherFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class CityListFragment extends MvpAppCompatFragment implements CityListView, ClickInterfaceKt {

    @InjectPresenter
    CityListPresenter presenter;
    @BindView(R.id.container)
    RecyclerView recyclerView;
    @BindString(R.string.toolbar_title)
    String title;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.city_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            ((NewWeatherActivity) getActivity()).setMyTitle(title);
            ((NewWeatherActivity) getActivity()).setMySubtitle("");
            ((NewWeatherActivity) getActivity()).showArrow(false);
        }
    }

    @Override
    public void showCityList(List <CityModelKt> list) {
        CityListAdapter adapter = new CityListAdapter(list, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void click(@NotNull CityListModel model) {
        WeatherFragment weatherFragment = WeatherFragment.newInstance(model);
        FragmentManager manager = getFragmentManager();
        if (manager == null) return;
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, weatherFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

