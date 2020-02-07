package me.teenyda.nCoV.model.news.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.news.model.IManagerModel;
import me.teenyda.nCoV.model.news.model.ManagerModelImpl;
import me.teenyda.nCoV.model.news.view.IManagerView;

public class ManagerPresenter extends BasePresenter<IManagerView, IManagerModel> {

    public ManagerPresenter() {
        mModel = new ManagerModelImpl();
    }
}
