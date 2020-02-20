package me.teenyda.nCoV.model.news.broadcast.model;

import io.reactivex.Observable;
import me.teenyda.nCoV.base.net.BaseResponse;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public interface IBroadcastModel {

    Observable<BaseResponse> rx_getBroadcast();
}
