package me.teenyda.nCoV.model.help;

import android.content.Context;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.help.model.IHelpModel;
import me.teenyda.nCoV.model.help.presenter.HelpPresenter;
import me.teenyda.nCoV.model.help.view.IHelpView;

public class HelpFrag extends MvpFragment<IHelpView, IHelpModel, HelpPresenter> implements IHelpView {
    @Override
    protected HelpPresenter initPresenter() {
        return new HelpPresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_my;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void doBuseness() {

    }

    @Override
    public Context getMContext() {
        return getContext();
    }
}
