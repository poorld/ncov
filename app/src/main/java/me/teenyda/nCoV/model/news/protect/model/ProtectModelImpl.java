package me.teenyda.nCoV.model.news.protect.model;

import io.reactivex.Observable;
import me.teenyda.nCoV.base.net.API_Factory;
import me.teenyda.nCoV.base.net.BaseRequest;
import me.teenyda.nCoV.base.net.BaseResponse;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class ProtectModelImpl implements IProtectModel {
    @Override
    public Observable<BaseResponse> rx_getRumorList() {
        return API_Factory.rx_getIndexRumorList(new BaseRequest());
    }
}
