package me.teenyda.nCoV.model.query.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.query.model.IQueryModel;
import me.teenyda.nCoV.model.query.model.QueryModelImpl;
import me.teenyda.nCoV.model.query.view.IQueryView;

public class QueryPresenter extends BasePresenter<IQueryView, IQueryModel> {

    public QueryPresenter() {
        mModel = new QueryModelImpl();
    }
}
