package com.wiktor.weater1.newWeaher.cityList.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wiktor.weater1.R;
import com.wiktor.weater1.newWeaher.cityList.adapter.CityListAdapter;
import com.wiktor.weater1.newWeaher.cityList.adapter.ClickInterface;
import com.wiktor.weater1.newWeaher.cityList.model.CityModel;
import com.wiktor.weater1.newWeaher.weatherDetalisation.mvp.WeatherFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CityListFragment extends Fragment implements CityListContract.View, ClickInterface {

    CityListContract.Presenter presenter = new CityListPresenter(this);
    @BindView(R.id.container)
    RecyclerView recyclerView;

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
    public void showCityList(List<CityModel> list) {
        CityListAdapter adapter = new CityListAdapter(list, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void click(CityModel model) {

        WeatherFragment weatherFragment = WeatherFragment.newInstance(model);

        FragmentManager manager = getFragmentManager();
        if (manager == null) return;
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame, weatherFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        //Toast.makeText(getContext(), "клик" + model.getName(), Toast.LENGTH_SHORT).show();
    }
}

