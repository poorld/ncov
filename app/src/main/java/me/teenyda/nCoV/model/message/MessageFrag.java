package me.teenyda.nCoV.model.message;

import android.content.Context;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.message.model.IMessageModel;
import me.teenyda.nCoV.model.message.presenter.MessagePresenter;
import me.teenyda.nCoV.model.message.view.IMessageView;

public class MessageFrag extends MvpFragment<IMessageView, IMessageModel, MessagePresenter> implements IMessageView {
    @Override
    protected MessagePresenter initPresenter() {
        return new MessagePresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_message;
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
