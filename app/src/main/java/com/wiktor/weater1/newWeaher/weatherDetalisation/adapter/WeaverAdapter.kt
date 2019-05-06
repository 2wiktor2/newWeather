package com.wiktor.weater1.newWeaher.weatherDetalisation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.ButterKnife
import com.squareup.picasso.Picasso
import com.wiktor.weater1.R
import com.wiktor.weater1.newWeaher.weatherDetalisation.model.WeatherModelForView

class WeaverAdapter(private val list: List<WeatherModelForView>) : RecyclerView.Adapter<WeaverAdapter.MyWeatherViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyWeatherViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.item_forecast_weaver, viewGroup, false)
        return MyWeatherViewHolder(view)
    }

    override fun onBindViewHolder(myWeatherViewHolder: MyWeatherViewHolder, i: Int) {
        myWeatherViewHolder.bind(list[i])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyWeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date: TextView
        var maxTemp: TextView
        var image: ImageView

        init {
            ButterKnife.bind(this, itemView)
            date = itemView.findViewById(R.id.item_text_view_date)
            maxTemp = itemView.findViewById(R.id.item_text_view_max_temp)
            image = itemView.findViewById(R.id.item_image_view)
        }

        fun bind(weatherModelForView: WeatherModelForView) {

            date.text = weatherModelForView.date
            maxTemp.text = weatherModelForView.maxTemperature.toString() + "°" + " / " + weatherModelForView.minTemperature + "°"

            Picasso.get()
                    .load(weatherModelForView.imageUrl)
                    .placeholder(R.drawable.ic_refresh_black_24dp)
                    .error(R.drawable.ic_error_outline_black_24dp)
                    .into(image)


        }
    }
}
