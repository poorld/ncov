package me.teenyda.nCoV.model.news.broadcast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.teenyda.nCoV.R;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public class BroadcastAdapter extends RecyclerView.Adapter<BroadcastAdapter.ViewHolder> {

    private Context mContext;

    private View.OnClickListener mOnClickListener;

    public BroadcastAdapter(Context context) {
        mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.boradcast_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mOnClickListener != null) {
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        if (position == 0) {
            holder.broadcast_top_line.setVisibility(View.INVISIBLE);
        } else {
            holder.broadcast_top_line.setVisibility(View.VISIBLE);
        }

        if (position == 9) {
            holder.broadcast_bottom_line.setVisibility(View.INVISIBLE);
        } else {
            holder.broadcast_bottom_line.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View broadcast_top_line;
        View broadcast_bottom_line;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            broadcast_top_line = itemView.findViewById(R.id.broadcast_top_line);
            broadcast_bottom_line = itemView.findViewById(R.id.broadcast_bottom_line);

        }
    }
}
