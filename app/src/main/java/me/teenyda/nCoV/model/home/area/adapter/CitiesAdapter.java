package me.teenyda.nCoV.model.home.area.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.ProvinceDataEntity;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {

    private Context mContext;

    private List<ProvinceDataEntity.CitiesBean> mCities = new ArrayList<>();


    public CitiesAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<ProvinceDataEntity.CitiesBean> citiesBeans) {
        mCities.clear();
        mCities.addAll(citiesBeans);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_cities, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProvinceDataEntity.CitiesBean cities = mCities.get(position);

        holder.area.setText(cities.getCityName());
        holder.currentConfirmedCount.setText(String.valueOf(cities.getCurrentConfirmedCount()));
        holder.confirmedCount.setText(String.valueOf(cities.getConfirmedCount()));
        holder.death.setText(String.valueOf(cities.getDeadCount()));
        holder.cure.setText(String.valueOf(cities.getCuredCount()));
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView area;
        private TextView currentConfirmedCount;
        private TextView confirmedCount;
        private TextView death;
        private TextView cure;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            area = itemView.findViewById(R.id.area);
            currentConfirmedCount = itemView.findViewById(R.id.cities_currentConfirmedCount);
            confirmedCount = itemView.findViewById(R.id.cities_confirmedCount);
            death = itemView.findViewById(R.id.death);
            cure = itemView.findViewById(R.id.cure);
        }
    }
}
