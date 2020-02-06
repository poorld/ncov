package me.teenyda.nCoV.model.home.base.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.teenyda.nCoV.base.entity.BannerEntity;

/**
 * author: teenyda
 * date: 2020/2/5
 * description:
 */
public class BannerImageAdapter extends BannerAdapter<BannerEntity, BannerImageAdapter.BannerViewHolder> {

    public BannerImageAdapter(List<BannerEntity> datas) {
        super(datas);
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
                ));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder holder, BannerEntity data, int position, int size) {
        holder.mImageView.setImageResource(data.imageRes);
    }


    class BannerViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        public BannerViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            this.mImageView = itemView;
        }
    }
}
