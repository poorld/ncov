package me.teenyda.nCoV.model.home.area;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpActivity;
import me.teenyda.nCoV.base.view.popview.AreaDetailPopView;
import me.teenyda.nCoV.model.home.area.presenter.AreaPresenter;
import me.teenyda.nCoV.model.home.area.view.IAreaView;
import me.teenyda.nCoV.model.home.area.adapter.RVAdapter;
import me.teenyda.nCoV.model.home.base.model.IHomeModel;

/**
 * author: teenyda
 * date: 2020/2/6
 * description: 各地区情况
 */
public class AreaAct extends MvpActivity<IAreaView, IHomeModel, AreaPresenter> implements IAreaView{


    private RecyclerView rv;

    private AreaDetailPopView mPopView;

    @Override
    protected AreaPresenter initPresenter() {
        return new AreaPresenter();
    }

    @Override
    protected void doBuseness() {

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
        setTitle("你好");
        setBack();

        rv = (RecyclerView) $(R.id.home_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getMContext());
        rv.setLayoutManager(manager);
        RVAdapter rvAdapter = new RVAdapter(getMContext());
        rv.setAdapter(rvAdapter);
        mPopView = new AreaDetailPopView(getMContext());

        rvAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopView.show(v);
            }
        });
    }

    @Override
    public Context getMContext() {
        return this;
    }
}
