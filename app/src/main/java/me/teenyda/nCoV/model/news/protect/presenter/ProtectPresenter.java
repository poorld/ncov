package me.teenyda.nCoV.model.news.protect.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.news.protect.model.IProtectModel;
import me.teenyda.nCoV.model.news.protect.model.ProtectModelImpl;
import me.teenyda.nCoV.model.news.protect.view.IProtectView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class ProtectPresenter extends BasePresenter<IProtectView, IProtectModel> {

    public ProtectPresenter() {
        mModel = new ProtectModelImpl();
    }

}
