package me.teenyda.nCoV.model.my.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.my.model.IMyModel;
import me.teenyda.nCoV.model.my.model.MyModelImpl;
import me.teenyda.nCoV.model.my.view.IMyView;

public class MyPresenter extends BasePresenter<IMyView, IMyModel> {

    public MyPresenter() {
        mModel = new MyModelImpl();
    }
}
