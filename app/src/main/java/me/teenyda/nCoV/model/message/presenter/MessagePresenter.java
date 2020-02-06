package me.teenyda.nCoV.model.message.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.message.model.IMessageModel;
import me.teenyda.nCoV.model.message.model.MessageModelImpl;
import me.teenyda.nCoV.model.message.view.IMessageView;

public class MessagePresenter extends BasePresenter<IMessageView, IMessageModel> {

    public MessagePresenter() {
        mModel = new MessageModelImpl();
    }
}
