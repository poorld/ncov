package me.teenyda.nCoV.model.query.doquery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import me.teenyda.nCoV.R;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> {

    private Context mContext;

    private ItemClickListener mItemClickListener;

    // 默认选飞机
    private int selectedIndex = 0;

    private static final String[] types = {"飞机",
                                            "火车",
                                            "地铁",
                                            "长途客车/大巴",
                                            "公交车",
                                            "出租车",
                                            "轮船",
                                            "其他公共场所"};

    public TypeAdapter(Context context) {
        mContext = context;
    }

    public interface ItemClickListener{
        void onItemClickListener(int type);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setType(int type) {
        this.selectedIndex = type - 1;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_type, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(v -> {
                mItemClickListener.onItemClickListener(position + 1);
                selectedIndex = position;
                notifyDataSetChanged();
            });
        }
        holder.item_type_tv.setText(types[position]);
        if (position == selectedIndex) {
            holder.itemView.setSelected(true);
        } else {
            holder.itemView.setSelected(false);
        }
    }

    @Override
    public int getItemCount() {
        return types.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView item_type_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_type_tv = itemView.findViewById(R.id.item_type_tv);
        }
    }
}
