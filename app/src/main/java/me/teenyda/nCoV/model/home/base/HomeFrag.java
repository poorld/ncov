package me.teenyda.nCoV.model.home.base;

import android.content.Context;
import android.view.View;

import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.HashMap;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.BannerEntity;
import me.teenyda.nCoV.base.entity.BookEntity;
import me.teenyda.nCoV.base.map.ChinaMapInfoView;
import me.teenyda.nCoV.base.map.CnMap;
import me.teenyda.nCoV.base.map.CnMapConfig;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.base.tools.Provinces;
import me.teenyda.nCoV.model.home.area.AreaAct;
import me.teenyda.nCoV.model.home.base.adapter.ImageNetAdapter;
import me.teenyda.nCoV.model.home.base.model.IHomeModel;
import me.teenyda.nCoV.model.home.base.presenter.HomePresenter;
import me.teenyda.nCoV.model.home.base.view.IHomeView;

public class HomeFrag extends MvpFragment<IHomeView, IHomeModel, HomePresenter> implements IHomeView, ChinaMapInfoView.ChinaMapViewProvinceListener {

//    private CommonDialog mDialog;

    private ChinaMapInfoView imgMap;


    private Banner banner;

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_home;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void initView() {
//        setTitle("首页");


        // 幻灯片
        //创建（new banner()）或者布局文件中获取banner
        banner = (Banner) $(R.id.banner);
        //默认直接设置adapter就行了
        banner.setAdapter(new ImageNetAdapter(BannerEntity.getTestData3()))
            .setIndicator(new CircleIndicator(getMContext()))
            .setIndicatorNormalColor(getResources().getColor(R.color.c_eeeeee))
            .setIndicatorSelectedColor(getResources().getColor(R.color.c_f74c31));

        //地图
        imgMap = (ChinaMapInfoView) $(R.id.imgCnMap);
        imgMap.setChinaMapViewProvinceListener(this);
        CnMap cnMap = imgMap.getCnMap();
        HashMap<String, CnMapConfig> configMap = cnMap.configMap;
        for (int i = 0; i < configMap.size(); i++) {
            CnMapConfig cnMapConfig = configMap.get(cnMap.PROVINCE[i]);
            cnMapConfig.setText(Provinces.chineseProvince[i]);
            cnMapConfig.setTextColor(getResources().getColor(R.color.c_2c2c2c));
            int num = i % 5;
            switch (num) {
                case 0:
                    cnMapConfig.setFillColor(getResources().getColor(R.color.c_fceed3));
                    break;
                case 1:
                    cnMapConfig.setFillColor(getResources().getColor(R.color.c_f1a88b));
                    break;
                case 2:
                    cnMapConfig.setFillColor(getResources().getColor(R.color.c_e16553));
                    break;
                case 3:
                    cnMapConfig.setFillColor(getResources().getColor(R.color.c_c93830));
                    break;
                case 4:
                    cnMapConfig.setFillColor(getResources().getColor(R.color.c_771e1b));
                    cnMapConfig.setTextColor(getResources().getColor(R.color.c_ffffff));
                    break;
            }
        }

        $(R.id.rl_toArea).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(AreaAct.class);
            }
        });


//        mDialog = new CommonDialog.Builder()
//                .setContext(getMContext())
//                .setTitle("dialog")
//                .setMessage("helllo")
//                .setLayout(R.layout.dialog_common)
//                .setCancelable(false)
//                .setThemeResId(R.style.Dialog)
//                .setConfirmListener(new CommonDialog.Builder.ConfirmClick() {
//                    @Override
//                    public void onConfirmClick() {
//                        mPresenter.getBookList();
//                    }
//                })
//                .build();


    }

    @Override
    protected void doBuseness() {

    }

    @Override
    public void onStart() {
        super.onStart();
        banner.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stop();
    }

    @Override
    public Context getMContext() {
        return getContext();
    }

    @Override
    public void setBook(BookEntity book) {
        setTitle(book.getBookName());
    }

    @Override
    public void onProvinceClick(int i) {

    }

    @Override
    public void onProvinceLongClick(int i) {

    }
}
