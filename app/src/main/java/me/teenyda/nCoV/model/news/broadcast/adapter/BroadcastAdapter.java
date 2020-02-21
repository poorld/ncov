package me.teenyda.nCoV.model.news.broadcast.adapter;

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
import me.teenyda.nCoV.base.entity.BroadcastEntity;
import me.teenyda.nCoV.base.tools.TimeUtils;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public class BroadcastAdapter extends RecyclerView.Adapter<BroadcastAdapter.ViewHolder> {

    private Context mContext;

    private IOnItemClick mOnClickListener;

    private List<BroadcastEntity> broadcastList = new ArrayList<>();

    public interface IOnItemClick{
        void onItemClick(String url);
    }

    public BroadcastAdapter(Context context) {
        mContext = context;
    }

    public void setOnClickListener(IOnItemClick onClickListener) {
        mOnClickListener = onClickListener;
    }

    public void setData(List<BroadcastEntity> broadcastList) {
        this.broadcastList.clear();
        this.broadcastList.addAll(broadcastList);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.boradcast_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // 去掉上线条和下线条
        if (position == 0) {
            holder.broadcast_top_line.setVisibility(View.INVISIBLE);
        } else {
            holder.broadcast_top_line.setVisibility(View.VISIBLE);
        }

        if (position == broadcastList.size() - 1) {
            holder.broadcast_bottom_line.setVisibility(View.INVISIBLE);
        } else {
            holder.broadcast_bottom_line.setVisibility(View.VISIBLE);
        }

        BroadcastEntity broadcastEntity = broadcastList.get(position);

        if (mOnClickListener != null) {
            holder.itemView.setOnClickListener(v -> {
                mOnClickListener.onItemClick(broadcastEntity.getSourceUrl());
            });
        }
        holder.bc_time_before.setText(broadcastEntity.getPubDateStr());
        holder.bc_time.setText(TimeUtils.getTD(broadcastEntity.getPubDate(), TimeUtils.datePattern4));
        holder.bc_title.setText(broadcastEntity.getTitle());
        holder.bc_content.setText(broadcastEntity.getSummary());
        holder.bc_source.setText(broadcastEntity.getInfoSource());

    }

    @Override
    public int getItemCount() {
        return broadcastList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View broadcast_top_line;
        View broadcast_bottom_line;
        TextView bc_time_before;
        TextView bc_time;
        TextView bc_title;
        TextView bc_content;
        TextView bc_source;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            broadcast_top_line = itemView.findViewById(R.id.broadcast_top_line);
            broadcast_bottom_line = itemView.findViewById(R.id.broadcast_bottom_line);

            bc_time_before = itemView.findViewById(R.id.bc_time_before);
            bc_time = itemView.findViewById(R.id.bc_time);
            bc_title = itemView.findViewById(R.id.bc_title);
            bc_content = itemView.findViewById(R.id.bc_content);
            bc_source = itemView.findViewById(R.id.bc_source);
        }
    }
}
