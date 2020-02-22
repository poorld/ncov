package me.teenyda.nCoV.model.home.area;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.ProvinceDataEntity;
import me.teenyda.nCoV.base.mvp.MvpActivity;
import me.teenyda.nCoV.base.view.popview.AreaDetailPopView;
import me.teenyda.nCoV.model.home.area.model.IAreaModel;
import me.teenyda.nCoV.model.home.area.presenter.AreaPresenter;
import me.teenyda.nCoV.model.home.area.view.IAreaView;
import me.teenyda.nCoV.model.home.area.adapter.ProvinceAdapter;

/**
 * author: teenyda
 * date: 2020/2/6
 * description: 各地区情况
 */
public class AreaAct extends MvpActivity<IAreaView, IAreaModel, AreaPresenter> implements IAreaView{


    private RecyclerView rv;

    private AreaDetailPopView mPopView;

    private List<ProvinceDataEntity> mProvinceList;
    private ProvinceAdapter provinceAdapter;

    public static void startAreaAct(Context context) {
        Intent intent = new Intent(context, AreaAct.class);
        context.startActivity(intent);
    }

    @Override
    protected AreaPresenter initPresenter() {
        return new AreaPresenter();
    }

    @Override
    protected void doBuseness() {
        mPresenter.getProvinceData();
    }

    @Override
    protected int setR_layout() {
        return R.layout.act_area;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void initView() {
        rv = (RecyclerView) $(R.id.home_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getMContext());
        rv.setLayoutManager(manager);
        provinceAdapter = new ProvinceAdapter(getMContext());
        rv.setAdapter(provinceAdapter);


        mPopView = new AreaDetailPopView(getMContext());
        provinceAdapter.setOnClickListener((v,province, cities) -> {
            mPopView.setProvinceTitle(province);
            mPopView.setData(cities);
            mPopView.show(v);
        });

        $(R.id.area_back).setOnClickListener(v -> finish());
    }

    @Override
    public Context getMContext() {
        return this;
    }

    @Override
    public void setProvinceData(List<ProvinceDataEntity> provinceList) {
        mProvinceList = provinceList;
        provinceAdapter.setData(provinceList);
    }
}
