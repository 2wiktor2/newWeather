package com.wiktor.weater1.newWeaher.cityList.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wiktor.weater1.R
import com.wiktor.weater1.newWeaher.cityList.model.CityModel

class CityListAdapter(
        private val list: List<CityModel>,
        private val clickInterface: ClickInterface)
    : RecyclerView.Adapter<CityListAdapter.CityListViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CityListViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.item_city, viewGroup, false)
        return CityListViewHolder(view)
    }


    override fun onBindViewHolder(cityListViewHolder: CityListViewHolder, i: Int) {
        cityListViewHolder.bind(list[i])
    }

    override fun getItemCount() = list.size


    inner class CityListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.item_text_view)
            itemView.setOnClickListener {
                val model = list[adapterPosition]
                clickInterface.click(model)
            }
        }


        fun bind(model: CityModel) {
            textView.text = model.name
        }

    }
}
