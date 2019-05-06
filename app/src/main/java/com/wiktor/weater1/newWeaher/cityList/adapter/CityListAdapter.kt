package com.wiktor.weater1.newWeaher.cityList.adapter

/*
class CityListAdapter : RecyclerView.Adapter<CityListAdapter.CityListViewHolder> {

    private val list: List<CityModel>? = null
    private val clickInterface: ClickInterface


    fun CityListAdapter(list: List<CityModel>, clickInterface: ClickInterface): ??? {
        this.list = list
        this.clickInterface = clickInterface
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CityListViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.item_city, viewGroup, false)
        return CityListViewHolder(view)
    }


    override fun onBindViewHolder(cityListViewHolder: CityListViewHolder, i: Int) {
        cityListViewHolder.bind(list!![i])
    }

    override fun getItemCount(): Int {
        return list!!.size
    }


    internal inner class CityListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView

        init {

            ButterKnife.bind(this, itemView)
            textView = itemView.findViewById(R.id.item_text_view)
            itemView.setOnClickListener {
                val model = list!![adapterPosition]
                clickInterface.click(model)
            }
        }


        fun bind(model: CityModel) {
            textView.text = model.name
        }

    }
}*/
