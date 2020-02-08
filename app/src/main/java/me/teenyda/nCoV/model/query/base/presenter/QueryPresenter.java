package me.teenyda.nCoV.model.query.base.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.query.base.model.IQueryModel;
import me.teenyda.nCoV.model.query.base.model.QueryModelImpl;
import me.teenyda.nCoV.model.query.base.view.IQueryView;

public class QueryPresenter extends BasePresenter<IQueryView, IQueryModel> {

    public QueryPresenter() {
        mModel = new QueryModelImpl();
    }
}
