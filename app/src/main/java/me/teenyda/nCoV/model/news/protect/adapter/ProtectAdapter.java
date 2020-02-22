package me.teenyda.nCoV.model.news.protect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.RumorEntity;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public class ProtectAdapter extends RecyclerView.Adapter<ProtectAdapter.ViewHolder> {

    private Context mContext;

    private View.OnClickListener mOnClickListener;

    private List<RumorEntity> mRumors = new ArrayList<>();

    public ProtectAdapter(Context context) {
        mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public void setData(List<RumorEntity> rumorEntities) {
        mRumors.clear();
        mRumors.addAll(rumorEntities);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.protect_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mOnClickListener != null) {
            holder.itemView.setOnClickListener(mOnClickListener);
        }
        // 0 谣言 1真 2尚未定论
        RumorEntity rumorEntity = mRumors.get(position);
        holder.rumour_title.setText(rumorEntity.getTitle());
        holder.protect_rumours.setText(rumorEntity.getMainSummary());
        holder.rumour_answer.setText(rumorEntity.getBody());
        switch (rumorEntity.getRumorType()) {
            case 0:
                holder.rumour_iv.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_rumours));
                break;
            case 1:
                holder.rumour_iv.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_true));
                break;
            case 2:
                holder.rumour_iv.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_unknown));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mRumors.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView rumour_title;
        TextView protect_rumours;
        TextView rumour_answer;
        ImageView rumour_iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rumour_title = itemView.findViewById(R.id.rumour_title);
            protect_rumours = itemView.findViewById(R.id.protect_rumours);
            rumour_answer = itemView.findViewById(R.id.rumour_answer);
            rumour_iv = itemView.findViewById(R.id.rumour_iv);
        }
    }
}
