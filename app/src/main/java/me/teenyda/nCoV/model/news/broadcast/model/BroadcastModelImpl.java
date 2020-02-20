package me.teenyda.nCoV.model.news.broadcast.model;

import io.reactivex.Observable;
import me.teenyda.nCoV.base.net.API_Factory;
import me.teenyda.nCoV.base.net.BaseRequest;
import me.teenyda.nCoV.base.net.BaseResponse;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class BroadcastModelImpl implements IBroadcastModel {
    @Override
    public Observable<BaseResponse> rx_getBroadcast() {
        return API_Factory.rx_getBroadcast(new BaseRequest());
    }
}
