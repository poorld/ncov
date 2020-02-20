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

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ViewHolder> {

    private Context mContext;

    private OnAreaClickListener mOnAreaClickListener;

    private List<ProvinceDataEntity> mProvinceList = new ArrayList<>();

    public interface OnAreaClickListener{
        void onAreaClickListener(View v,String province, List<ProvinceDataEntity.CitiesBean> citiesBeans);
    }
    public void setOnClickListener(OnAreaClickListener onClickListener) {
        mOnAreaClickListener = onClickListener;
    }

    public ProvinceAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<ProvinceDataEntity> provinceList) {
        mProvinceList.clear();
        mProvinceList.addAll(provinceList);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_province, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProvinceDataEntity province = mProvinceList.get(position);
        if (mOnAreaClickListener != null) {
            holder.itemView.setOnClickListener(v -> mOnAreaClickListener.onAreaClickListener(v,province.getProvinceShortName(), province.getCities()));
        }
        holder.area.setText(province.getProvinceShortName());
        holder.currentConfirmedCount.setText(String.valueOf(province.getCurrentConfirmedCount()));
        holder.confirmedCount.setText(String.valueOf(province.getConfirmedCount()));
        holder.death.setText(String.valueOf(province.getDeadCount()));
        holder.cure.setText(String.valueOf(province.getCuredCount()));
    }

    @Override
    public int getItemCount() {
        return mProvinceList.size();
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
            currentConfirmedCount = itemView.findViewById(R.id.province_currentConfirmedCount);
            confirmedCount = itemView.findViewById(R.id.province_confirmedCount);
            death = itemView.findViewById(R.id.death);
            cure = itemView.findViewById(R.id.cure);
        }
    }
}
