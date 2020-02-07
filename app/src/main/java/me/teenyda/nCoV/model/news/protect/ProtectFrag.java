package me.teenyda.nCoV.model.news.protect;

import android.content.Context;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.news.protect.model.IProtectModel;
import me.teenyda.nCoV.model.news.protect.presenter.ProtectPresenter;
import me.teenyda.nCoV.model.news.protect.view.IProtectView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class ProtectFrag extends MvpFragment<IProtectView,IProtectModel,ProtectPresenter> implements IProtectView{

    @Override
    protected ProtectPresenter initPresenter() {
        return new ProtectPresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_protect;
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
