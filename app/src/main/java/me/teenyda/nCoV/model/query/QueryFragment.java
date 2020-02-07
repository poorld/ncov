package me.teenyda.nCoV.model.query;

import android.content.Context;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.query.model.IQueryModel;
import me.teenyda.nCoV.model.query.presenter.QueryPresenter;
import me.teenyda.nCoV.model.query.view.IQueryView;

public class QueryFragment extends MvpFragment<IQueryView, IQueryModel, QueryPresenter> implements IQueryView {
    @Override
    protected QueryPresenter initPresenter() {
        return new QueryPresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_message;
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
