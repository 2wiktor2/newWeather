package com.wiktor.weater1.newWeaher.cityList.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.*
import android.view.View
import android.view.ViewGroup
import com.wiktor.weater1.newWeaher.cityList.model.CityModelKt

class CityListAdapterKt : RecyclerView.Adapter<CityListAdapterKt.CityListViewHolderKt>() {

    val list: List<CityModelKt>
    var clickInterface: ClickInterfaceKt

    constructor(list: List<CityModelKt>, clickInterface: ClickInterfaceKt) : super() {
        this.list = list
        this.clickInterface = clickInterface
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CityListViewHolderKt {

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: CityListViewHolderKt, p1: Int) {
    }


    class CityListViewHolderKt(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.item_text_view

    }

}



