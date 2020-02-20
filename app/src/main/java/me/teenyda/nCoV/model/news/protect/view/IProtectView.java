package me.teenyda.nCoV.model.news.protect.view;

import java.util.List;

import me.teenyda.nCoV.base.entity.RumorEntity;
import me.teenyda.nCoV.base.mvp.BaseView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public interface IProtectView extends BaseView {

    void setRumor(List<RumorEntity> rumors);
}
