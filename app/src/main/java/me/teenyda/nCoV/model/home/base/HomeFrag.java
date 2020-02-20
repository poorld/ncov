package me.teenyda.nCoV.model.home.base;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.BannerEntity;
import me.teenyda.nCoV.base.entity.BookEntity;
import me.teenyda.nCoV.base.entity.ProvinceDataEntity;
import me.teenyda.nCoV.base.entity.StatisticsEntity;
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

//    现存确诊较昨日
    private TextView currentConfirmedIncr;
//    现存确诊
    private TextView currentConfirmedCount;

    //现存疑似
    private TextView suspectedIncr;
    private TextView suspectedCount;

    //现存重症
    private TextView seriousIncr;
    private TextView seriousCount;

    //累计确诊
    private TextView confirmedIncr;
    private TextView confirmedCount;

    //累计死亡
    private TextView deadIncr;
    private TextView deadCount;

    //累计治愈
    private TextView curedIncr;
    private TextView curedCount;

    private Banner banner;

    // 现存确诊 地图切换
    private TextView confirmed;
    // 累计确诊 地图切换
    private TextView total_confirmed;


    private List<ProvinceDataEntity> mProvinceList;

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
        currentConfirmedIncr = (TextView) $(R.id.currentConfirmedIncr);
        currentConfirmedCount = (TextView) $(R.id.currentConfirmedCount);
        suspectedIncr = (TextView) $(R.id.suspectedIncr);
        suspectedCount = (TextView) $(R.id.suspectedCount);
        seriousIncr = (TextView) $(R.id.seriousIncr);
        seriousCount = (TextView) $(R.id.seriousCount);
        confirmedIncr = (TextView) $(R.id.confirmedIncr);
        confirmedCount = (TextView) $(R.id.confirmedCount);
        deadIncr = (TextView) $(R.id.deadIncr);
        deadCount = (TextView) $(R.id.deadCount);
        curedIncr = (TextView) $(R.id.curedIncr);
        curedCount = (TextView) $(R.id.curedCount);

        confirmed = (TextView) $(R.id.confirmed);
        confirmed.setSelected(true);
        total_confirmed = (TextView) $(R.id.total_confirmed);
        // 幻灯片
        //创建（new banner()）或者布局文件中获取banner
        banner = (Banner) $(R.id.banner);


        //地图
        imgMap = (ChinaMapInfoView) $(R.id.imgCnMap);
        imgMap.setChinaMapViewProvinceListener(this);
        CnMap cnMap = imgMap.getCnMap();
        HashMap<String, CnMapConfig> configMap = cnMap.configMap;
        for (int i = 0; i < configMap.size(); i++) {
            CnMapConfig cnMapConfig = configMap.get(cnMap.PROVINCE[i]);
            cnMapConfig.setText(Provinces.chineseProvince[i]);
            cnMapConfig.setTextColor(getResources().getColor(R.color.c_2c2c2c));
        }

        $(R.id.rl_toArea).setOnClickListener(v -> {
            if (mProvinceList != null) {
                AreaAct.startAreaAct(getMContext());
            }
        });

        // 现存确诊人数 地图切换
        confirmed.setOnClickListener(v -> {
            if (mProvinceList != null) {
                confirmed.setSelected(true);
                total_confirmed.setSelected(false);
                setProvinceData(mProvinceList, false);
            }
        });
        // 累计确诊人数 地图切换
        total_confirmed.setOnClickListener(v -> {
            if (mProvinceList != null) {
                total_confirmed.setSelected(true);
                confirmed.setSelected(false);
                setProvinceData(mProvinceList, true);
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
        mPresenter.initData();
    }

    @Override
    public void onStart() {
        super.onStart();
//        banner.start();
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
    public void setData(StatisticsEntity statistics) {
        currentConfirmedIncr.setText(fromHtml("#f74c31", statistics.getCurrentConfirmedIncr()));
        currentConfirmedCount.setText(String.valueOf(statistics.getCurrentConfirmedCount()));

        suspectedIncr.setText(fromHtml("#f78207", statistics.getSuspectedIncr()));
        suspectedCount.setText(String.valueOf(statistics.getSuspectedCount()));

        seriousIncr.setText(fromHtml("#a25a4e", statistics.getSeriousIncr()));
        seriousCount.setText(String.valueOf(statistics.getSeriousCount()));

        confirmedIncr.setText(fromHtml("#8653fa",statistics.getConfirmedIncr()));
        confirmedCount.setText(String.valueOf(statistics.getConfirmedCount()));

        deadIncr.setText(fromHtml("#28b7a3", statistics.getDeadIncr()));
        deadCount.setText(String.valueOf(statistics.getDeadCount()));

        curedIncr.setText(fromHtml("#4c55a6", statistics.getCuredIncr()));
        curedCount.setText(String.valueOf(statistics.getCuredCount()));

        //默认直接设置adapter就行了
        banner.setAdapter(new ImageNetAdapter(statistics.getQuanguoTrendChart()))
                .setIndicator(new CircleIndicator(getMContext()))
                .setIndicatorNormalColor(getResources().getColor(R.color.c_eeeeee))
                .setIndicatorSelectedColor(getResources().getColor(R.color.c_f74c31));

        banner.start();
    }

    @Override
    public void setProvinceData(List<ProvinceDataEntity> provinceList, boolean total) {
        mProvinceList = provinceList;
        CnMap cnMap = imgMap.getCnMap();
        HashMap<String, CnMapConfig> configMap = cnMap.configMap;
        Set<String> strings = configMap.keySet();
        for (String key : strings) {
            for (ProvinceDataEntity province : provinceList) {
                String mapPrivince = configMap.get(key).getText();
                if (mapPrivince.equals(province.getProvinceShortName())) {
                    CnMapConfig cnMapConfig = configMap.get(key);

                    int count = 0;
                    if (total) {
                        // true总计
                        count = province.getConfirmedCount();
                    }else {
                        // false 现存确诊人数
                        count = province.getCurrentConfirmedCount();
                    }

                    if (count == 0) {
                        cnMapConfig.setFillColor(getResources().getColor(R.color.c_ffffff));
                    } else if (count < 9) {
                        cnMapConfig.setFillColor(getResources().getColor(R.color.c_fceed3));
                    } else if (count < 99){
                        cnMapConfig.setFillColor(getResources().getColor(R.color.c_f1a88b));
                    } else if (count < 499) {
                        cnMapConfig.setFillColor(getResources().getColor(R.color.c_e16553));
                    } else if (count < 999) {
                        cnMapConfig.setFillColor(getResources().getColor(R.color.c_c93830));
                    } else if (count <= 10000) {
                        cnMapConfig.setFillColor(getResources().getColor(R.color.c_771e1b));
                        cnMapConfig.setTextColor(getResources().getColor(R.color.c_ffffff));
                    } else {
                        cnMapConfig.setFillColor(getResources().getColor(R.color.c_4f070d));
                        cnMapConfig.setTextColor(getResources().getColor(R.color.c_ffffff));
                    }
                }
            }
        }
        imgMap.resetDrawable();
    }

    private Spanned fromHtml(String color, int incr) {
        String str = String.valueOf(incr);
        if (incr > 0) {
            str = "+" + incr;
        }
        return Html.fromHtml("较昨日<font color='" + color + "'>" + str + "</font>");
    }

    @Override
    public void onProvinceClick(int i) {

    }

    @Override
    public void onProvinceLongClick(int i) {

    }
}
