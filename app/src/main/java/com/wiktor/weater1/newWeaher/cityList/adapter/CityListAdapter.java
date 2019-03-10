package com.wiktor.weater1.newWeaher.cityList.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wiktor.weater1.R;
import com.wiktor.weater1.newWeaher.cityList.model.CityModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.CityListViewHolder> {

    private List<CityModel> list = null;
    private ClickInterface clickInterface;


    public CityListAdapter(List<CityModel> list, ClickInterface clickInterface) {
        this.list = list;
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public CityListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_city, viewGroup, false);
        return new CityListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CityListViewHolder cityListViewHolder, int i) {
        cityListViewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class CityListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_text_view)
        TextView textView;


        public CityListViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CityModel model = list.get(getAdapterPosition());
                    clickInterface.click(model);
                }
            });
        }


        public void bind(CityModel model) {
            textView.setText(model.getName());
        }

    }


}
