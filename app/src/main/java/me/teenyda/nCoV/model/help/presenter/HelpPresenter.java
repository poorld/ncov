package me.teenyda.nCoV.model.help.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.help.model.IHelpModel;
import me.teenyda.nCoV.model.help.model.HelpModelImpl;
import me.teenyda.nCoV.model.help.view.IHelpView;

public class HelpPresenter extends BasePresenter<IHelpView, IHelpModel> {

    public HelpPresenter() {
        mModel = new HelpModelImpl();
    }
}
