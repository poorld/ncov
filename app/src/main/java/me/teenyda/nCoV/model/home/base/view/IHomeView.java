package me.teenyda.nCoV.model.home.base.view;

import me.teenyda.nCoV.base.entity.BookEntity;
import me.teenyda.nCoV.base.mvp.BaseView;

public interface IHomeView extends BaseView {

    void setBook(BookEntity book);
}
