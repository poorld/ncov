package me.teenyda.nCoV.model.my;

import android.content.Context;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.my.model.IMyModel;
import me.teenyda.nCoV.model.my.presenter.MyPresenter;
import me.teenyda.nCoV.model.my.view.IMyView;

public class MyFrag extends MvpFragment<IMyView, IMyModel, MyPresenter> implements IMyView {
    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_my;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void doBuseness() {

    }

    @Override
    public Context getMContext() {
        return getContext();
    }
}
