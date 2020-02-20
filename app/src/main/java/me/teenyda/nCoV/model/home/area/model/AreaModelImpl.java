package me.teenyda.nCoV.model.home.area.model;


import io.reactivex.Observable;
import me.teenyda.nCoV.base.net.API_Factory;
import me.teenyda.nCoV.base.net.BaseRequest;
import me.teenyda.nCoV.base.net.BaseResponse;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public class AreaModelImpl implements IAreaModel {
    @Override
    public Observable<BaseResponse> rx_getProvinceData() {
        return API_Factory.rx_getProvinceData(new BaseRequest());
    }
}
