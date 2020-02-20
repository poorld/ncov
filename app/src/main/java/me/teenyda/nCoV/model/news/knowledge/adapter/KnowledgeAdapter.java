package me.teenyda.nCoV.model.news.knowledge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.KnowledgeEntity;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public class KnowledgeAdapter extends RecyclerView.Adapter<KnowledgeAdapter.ViewHolder> {

    private Context mContext;

    private View.OnClickListener mOnClickListener;

    private List<KnowledgeEntity> knowledgeList = new ArrayList<>();

    public KnowledgeAdapter(Context context) {
        mContext = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public void setData(List<KnowledgeEntity> list) {
        knowledgeList.clear();
        knowledgeList.addAll(list);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.knowledge_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mOnClickListener != null) {
            holder.itemView.setOnClickListener(mOnClickListener);
        }
        KnowledgeEntity knowledgeEntity = knowledgeList.get(position);
        Glide.with(holder.knowledge_iv)
                .load(knowledgeEntity.getImgUrl())
                .into(holder.knowledge_iv);

        holder.knowledge_title.setText(knowledgeEntity.getTitle());
        holder.knowledge_content.setText(knowledgeEntity.getDescription());
    }

    @Override
    public int getItemCount() {
        return knowledgeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView knowledge_iv;
        TextView knowledge_title;
        TextView knowledge_content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            knowledge_iv = itemView.findViewById(R.id.knowledge_iv);
            knowledge_title = itemView.findViewById(R.id.knowledge_title);
            knowledge_content = itemView.findViewById(R.id.knowledge_content);
        }
    }
}
