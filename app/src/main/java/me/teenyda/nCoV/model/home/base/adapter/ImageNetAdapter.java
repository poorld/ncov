package me.teenyda.nCoV.model.home.base.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

import me.teenyda.nCoV.base.entity.BannerEntity;
import me.teenyda.nCoV.base.entity.ImageHolder;

/**
 * 自定义布局，网络图片
 */
public class ImageNetAdapter extends BannerAdapter<BannerEntity,ImageHolder> {

    public ImageNetAdapter(List<BannerEntity> mDatas) {
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
    public void onBindView(ImageHolder holder, BannerEntity data, int position, int size) {

        //glide
        Glide.with(holder.itemView).load(data.imageUrl).into(holder.imageView);
    }

}
