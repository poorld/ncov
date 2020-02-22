package me.teenyda.nCoV.model.query.doquery.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.query.doquery.model.IDoQueryModel;
import me.teenyda.nCoV.model.query.doquery.model.DoQueryModelImpl;
import me.teenyda.nCoV.model.query.doquery.view.IDoQueryView;

public class DoQueryPresenter extends BasePresenter<IDoQueryView, IDoQueryModel> {

    public DoQueryPresenter() {
        mModel = new DoQueryModelImpl();
    }


}
