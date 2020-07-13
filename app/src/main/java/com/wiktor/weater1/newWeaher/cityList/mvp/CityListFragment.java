package com.wiktor.weater1.newWeaher.cityList.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.wiktor.weater1.R;
import com.wiktor.weater1.newWeaher.NewWeatherActivity;
import com.wiktor.weater1.newWeaher.cityList.adapter.CityListAdapter;
import com.wiktor.weater1.newWeaher.cityList.adapter.ClickInterface;
import com.wiktor.weater1.newWeaher.cityList.model.CityModel;
import com.wiktor.weater1.newWeaher.weatherDetalisation.mvp.WeatherFragment;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class CityListFragment extends Fragment implements CityListView, ClickInterface {

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
        if (presenter != null) {
            presenter.start();
        }
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
        transaction.replace(R.id.frame, weatherFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

