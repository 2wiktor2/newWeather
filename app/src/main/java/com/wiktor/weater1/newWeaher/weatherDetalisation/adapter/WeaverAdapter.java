package com.wiktor.weater1.newWeaher.weatherDetalisation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wiktor.weater1.R;
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WeaverAdapter extends RecyclerView.Adapter<WeaverAdapter.MyWeatherViewHolder> {

    private List<WeatherModelForView> list;

    public WeaverAdapter(List<WeatherModelForView> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_forecast_weaver, viewGroup, false);
        return new MyWeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyWeatherViewHolder myWeatherViewHolder, int i) {
        myWeatherViewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyWeatherViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_text_view_date)
        TextView date;
        @BindView(R.id.item_text_view_max_temp)
        TextView maxTemp;
        @BindView(R.id.item_image_view)
        ImageView image;
        @BindString(R.string.symbolGradus)  String degreeСelsius;
        @BindString(R.string.symbolForSeparate) String symbol;

        public MyWeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(WeatherModelForView weatherModelForView) {
            date.setText(weatherModelForView.getDate());
            maxTemp.setText(weatherModelForView.getMaxTemperature()+degreeСelsius +symbol+ weatherModelForView.getMinTemperature()+degreeСelsius );
          // minTemp.setText(weatherModelForView.getMinTemperature().toString());

            Picasso.get()
                    .load(weatherModelForView.getImageUrl())
                    .placeholder(R.drawable.ic_refresh_black_24dp)
                    .error(R.drawable.ic_error_outline_black_24dp)
                    .into(image);


        }
    }
}
