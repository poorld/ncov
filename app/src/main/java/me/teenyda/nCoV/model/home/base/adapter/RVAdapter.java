package me.teenyda.nCoV.model.home.base.adapter;

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
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private Context mContext;

    private View.OnClickListener mOnClickListener;

    public RVAdapter(Context context) {
        mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_rv_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mOnClickListener != null) {
            holder.itemView.setOnClickListener(mOnClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView area;
        private TextView confirmed;
        private TextView death;
        private TextView cure;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            area = itemView.findViewById(R.id.area);
            confirmed = itemView.findViewById(R.id.confirmed);
            death = itemView.findViewById(R.id.death);
            cure = itemView.findViewById(R.id.cure);

        }
    }
}
