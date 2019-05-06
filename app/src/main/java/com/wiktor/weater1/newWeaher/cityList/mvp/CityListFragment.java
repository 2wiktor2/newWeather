package com.wiktor.weater1.newWeaher.cityList.mvp;

/*public class CityListFragment extends MvpAppCompatFragment implements CityListView, ClickInterface {

    @InjectPresenter
    CityListPresenter presenter;
//    @BindView(R.id.container)
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

        recyclerView = getView().findViewById(R.id.container);
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
}*/


