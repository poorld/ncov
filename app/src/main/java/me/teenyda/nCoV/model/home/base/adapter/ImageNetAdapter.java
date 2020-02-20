package me.teenyda.nCoV.model.home.base.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

import me.teenyda.nCoV.base.entity.BannerEntity;
import me.teenyda.nCoV.base.entity.ImageHolder;
import me.teenyda.nCoV.base.entity.StatisticsEntity;

/**
 * 自定义布局，网络图片
 */
public class ImageNetAdapter extends BannerAdapter<StatisticsEntity.QuanguoTrendChartBean,ImageHolder> {

    public ImageNetAdapter(List<StatisticsEntity.QuanguoTrendChartBean> mDatas) {
        super(mDatas);
    }

    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder holder, StatisticsEntity.QuanguoTrendChartBean data, int position, int size) {
        Glide.with(holder.itemView).load(data.getImgUrl()).into(holder.imageView);

    }


}
