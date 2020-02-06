package me.teenyda.nCoV.model.home.area.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.home.area.model.AreaModelImpl;
import me.teenyda.nCoV.model.home.area.model.IAreaModel;
import me.teenyda.nCoV.model.home.area.view.IAreaView;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public class AreaPresenter extends BasePresenter<IAreaView, IAreaModel> {

    public AreaPresenter() {
        mModel = new AreaModelImpl();
    }


}
