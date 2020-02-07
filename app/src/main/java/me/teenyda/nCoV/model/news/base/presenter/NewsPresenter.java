package me.teenyda.nCoV.model.news.base.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.news.base.model.INewsModel;
import me.teenyda.nCoV.model.news.base.model.NewsModelImpl;
import me.teenyda.nCoV.model.news.base.view.INewsView;

public class NewsPresenter extends BasePresenter<INewsView, INewsModel> {

    public NewsPresenter() {
        mModel = new NewsModelImpl();
    }
}
