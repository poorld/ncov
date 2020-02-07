package me.teenyda.nCoV.model.news;

import android.content.Context;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.news.model.IManagerModel;
import me.teenyda.nCoV.model.news.presenter.ManagerPresenter;
import me.teenyda.nCoV.model.news.view.IManagerView;

public class ManagerFrag extends MvpFragment<IManagerView, IManagerModel, ManagerPresenter> implements IManagerView {
    @Override
    protected ManagerPresenter initPresenter() {
        return new ManagerPresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_store;
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
