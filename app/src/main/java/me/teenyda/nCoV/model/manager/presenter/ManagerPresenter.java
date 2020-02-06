package me.teenyda.nCoV.model.manager.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.manager.model.IManagerModel;
import me.teenyda.nCoV.model.manager.model.ManagerModelImpl;
import me.teenyda.nCoV.model.manager.view.IManagerView;

public class ManagerPresenter extends BasePresenter<IManagerView, IManagerModel> {

    public ManagerPresenter() {
        mModel = new ManagerModelImpl();
    }
}
