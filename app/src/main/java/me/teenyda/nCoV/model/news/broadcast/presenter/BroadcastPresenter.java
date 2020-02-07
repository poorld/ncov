package me.teenyda.nCoV.model.news.broadcast.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.news.protect.model.IProtectModel;
import me.teenyda.nCoV.model.news.protect.model.ProtectModelImpl;
import me.teenyda.nCoV.model.news.protect.view.IProtectView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class BroadcastPresenter extends BasePresenter<IProtectView, IProtectModel> {

    public BroadcastPresenter() {
        mModel = new ProtectModelImpl();
    }

}
