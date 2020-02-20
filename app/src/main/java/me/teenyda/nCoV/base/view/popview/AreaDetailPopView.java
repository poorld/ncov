package me.teenyda.nCoV.base.view.popview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.ProvinceDataEntity;
import me.teenyda.nCoV.model.home.area.adapter.CitiesAdapter;
import me.teenyda.nCoV.model.home.area.adapter.ProvinceAdapter;

public class AreaDetailPopView {

    private Context mContext;
    private PopupWindow mPopupWindow;
    private View mView;
    private RecyclerView mRecyclerView;
    private CitiesAdapter mAdapter;
    private TextView tv_pop_title;

    public AreaDetailPopView(Context context) {
        mContext = context;
        initPopView();
    }


    private void initPopView() {
        mView = LayoutInflater.from(mContext).inflate(R.layout.pop_area_detail, null, false);
        tv_pop_title = mView.findViewById(R.id.tv_pop_title);

        mRecyclerView = mView.findViewById(R.id.pop_area_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new CitiesAdapter(mContext);
        mRecyclerView.setAdapter(mAdapter);

        mPopupWindow = new PopupWindow(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setOnDismissListener(() -> backgroundAlpha(1f));

    }

    public void setProvinceTitle(String province) {
        tv_pop_title.setText(province);
    }

    public void setData(List<ProvinceDataEntity.CitiesBean> cities) {
        mAdapter.setData(cities);
    }


    public void show(View v) {
        // setFocusable 默认是false
        // setFocusable(true)外部和内部都会响应，点击外部就会取消，setOutsideTouchable(false)失效
        mPopupWindow.setFocusable(true);
        // 设置PopupWindow是否能响应点击事件
        mPopupWindow.setTouchable(true);
        // 设置PopupWindow内容区域外的区域是否响应点击事件（true：响应；false：不响应）
        mPopupWindow.setOutsideTouchable(false);

        mPopupWindow.showAtLocation(v, Gravity.CENTER, 0 , 0);
        backgroundAlpha(0.5f);
    }

    public void dismiss() {
        mPopupWindow.dismiss();
    }

    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
        lp.alpha = bgAlpha;
        ((Activity) mContext).getWindow().setAttributes(lp);
    }
}
