package me.teenyda.nCoV.model.home.base.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.StatisticsEntity;


/**
 * 自定义布局，图片+标题
 */

public class ImageTitleAdapter extends BannerAdapter<StatisticsEntity.QuanguoTrendChartBean, ImageTitleAdapter.ImageTitleHolder> {

    public ImageTitleAdapter(List<StatisticsEntity.QuanguoTrendChartBean> mDatas) {
        super(mDatas);
    }

    @Override
    public ImageTitleHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new ImageTitleHolder(BannerUtils.getView(parent, R.layout.banner_image_title));
    }

    @Override
    public void onBindView(ImageTitleHolder holder, StatisticsEntity.QuanguoTrendChartBean data, int position, int size) {
        Glide.with(holder.itemView).load(data.getImgUrl()).into(holder.banner_iv);
        holder.banner_title.setText(data.getTitle());
    }


    class ImageTitleHolder extends RecyclerView.ViewHolder {
        public ImageView banner_iv;
        public TextView banner_title;

        public ImageTitleHolder(@NonNull View view) {
            super(view);
            banner_iv = view.findViewById(R.id.banner_iv);
            banner_title = view.findViewById(R.id.banner_title);
        }
    }

}
