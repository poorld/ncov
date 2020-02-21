package me.teenyda.nCoV.model.web.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.web.model.IWebModel;
import me.teenyda.nCoV.model.web.model.WebModelImpl;
import me.teenyda.nCoV.model.web.view.IWebView;

public class WebPresenter extends BasePresenter<IWebView, IWebModel> {

    public WebPresenter() {
        mModel = new WebModelImpl();
    }

}
