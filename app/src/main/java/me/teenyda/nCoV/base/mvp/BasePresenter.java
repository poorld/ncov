package me.teenyda.nCoV.base.mvp;

import android.content.Context;

public class BasePresenter<V extends BaseView, M> {

    protected V mView;
    protected Context mContext;
    protected M mModel;
    

    public void attach(V view) {
        this.mView = view;
        mContext = mView.getMContext();
    }
}
