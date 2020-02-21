package me.teenyda.nCoV.model.query.base.adapter;

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
import me.teenyda.nCoV.base.entity.response.NcovSameEntity;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public class QueryAdapter extends RecyclerView.Adapter<QueryAdapter.ViewHolder> {

    private Context mContext;

    private View.OnClickListener mOnClickListener;

    private List<NcovSameEntity> datas = new ArrayList<>();


    public QueryAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<NcovSameEntity> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.query_item, parent, false);

        return new ViewHolder(view);
    }

    //1飞机，2火车，3地铁，4长途客车/大巴，5公交车，6出租车，7轮船，8其他公共场所
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mOnClickListener != null) {
            holder.itemView.setOnClickListener(mOnClickListener);
        }
        NcovSameEntity ncovSame = datas.get(position);
        holder.query_start.setText(ncovSame.getPos_start());
        holder.query_end.setText(ncovSame.getPos_end());
        holder.query_start_time.setText(ncovSame.getStart());
        holder.query_end_time.setText(ncovSame.getEnd());
        holder.query_no.setText(ncovSame.getNo());
        String text = "";
        switch (ncovSame.getType()) {
            case 1:
                text = "飞机";
                break;
            case 2:
                text = "火车";
                break;
            case 3:
                text = "地铁";
                break;
            case 4:
                text = "长途客车/大巴";
                break;
            case 5:
                text = "公交车";
                break;
            case 6:
                text = "出租车";
                break;
            case 7:
                text = "轮船";
                break;
            case 8:
                text = "公共场所";
                break;
        }
        holder.query_type.setText(text);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView query_start;
        TextView query_end;
        TextView query_start_time;
        TextView query_end_time;
        TextView query_no;
        TextView query_type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            query_start = itemView.findViewById(R.id.query_start);
            query_end = itemView.findViewById(R.id.query_end);
            query_start_time = itemView.findViewById(R.id.query_start_time);
            query_end_time = itemView.findViewById(R.id.query_end_time);
            query_no = itemView.findViewById(R.id.query_no);
            query_type = itemView.findViewById(R.id.query_type);
        }
    }
}
