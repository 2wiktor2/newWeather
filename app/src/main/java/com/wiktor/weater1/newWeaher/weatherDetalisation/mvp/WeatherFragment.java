package com.wiktor.weater1.newWeaher.weatherDetalisation.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wiktor.weater1.R;
import com.wiktor.weater1.newWeaher.NewWeatherActivity;
import com.wiktor.weater1.newWeaher.cityList.model.CityModel;
import com.wiktor.weater1.newWeaher.weatherDetalisation.adapter.WeaverAdapter;
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView;

import java.util.List;
import java.util.Objects;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherFragment extends Fragment implements WeatherContract.View {

    @BindView(R.id.recycler_view_container)
    RecyclerView mRecyclerView;
    @BindString(R.string.symbolGradus)
    String gradus;
    @BindString(R.string.toolbar_title)
    String title;

    private final static String KEY_CITY_MODEL = "key_city_model";

    public static WeatherFragment newInstance(CityModel cityModel) {
        WeatherFragment weatherFragment = new WeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_CITY_MODEL, cityModel);
        weatherFragment.setArguments(bundle);
        return weatherFragment;
    }

    WeatherContract.Presenter presenter = new WeatherPresenter(this);

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.weather_detalisation_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arg = getArguments();
        if (arg != null) {
            CityModel model = (CityModel) arg.getSerializable(KEY_CITY_MODEL);
            if (model != null) {
                presenter.start(model);
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((NewWeatherActivity) Objects.requireNonNull(getActivity())).showArrow(true);
    }

    // отмена запросов
    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }


    @Override
    public void showData(double temperature) {
        ((NewWeatherActivity) Objects.requireNonNull(getActivity()))
                .setMySubtitle("Сейчас: " + temperature + gradus);
    }

    @Override
    public void showErrorDialog(String error) {
        Toast.makeText(getContext(), "Ошибка: " + error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(List <WeatherModelForView> list) {
        WeaverAdapter adapter = new WeaverAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                Objects.requireNonNull(getContext()), LinearLayout.VERTICAL));
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void changeTitle(CityModel cityModel) {
        ((NewWeatherActivity) Objects.requireNonNull(getActivity())).setMyTitle(cityModel.getName());
    }


}

