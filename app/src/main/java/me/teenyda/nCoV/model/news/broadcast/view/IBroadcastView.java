package me.teenyda.nCoV.model.news.broadcast.view;

import java.util.List;

import me.teenyda.nCoV.base.entity.BroadcastEntity;
import me.teenyda.nCoV.base.mvp.BaseView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public interface IBroadcastView extends BaseView {

    void setBroadcast(List<BroadcastEntity> broadcastList);
}
