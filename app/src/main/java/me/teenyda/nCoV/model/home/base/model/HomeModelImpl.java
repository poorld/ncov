package me.teenyda.nCoV.model.home.base.model;

import io.reactivex.Observable;
import me.teenyda.nCoV.base.net.API_Factory;
import me.teenyda.nCoV.base.net.BaseRequest;
import me.teenyda.nCoV.base.net.BaseResponse;

public class HomeModelImpl implements IHomeModel {
    @Override
    public Observable<BaseResponse> rx_getBookList() {
        return API_Factory.rx_getBookList(new BaseRequest());
    }

    @Override
    public Observable<BaseResponse> rx_initData() {
        return API_Factory.rx_initData(new BaseRequest());
    }

    @Override
    public Observable<BaseResponse> rx_getIndexData() {
        return API_Factory.rx_getIndexData(new BaseRequest());
    }

    @Override
    public Observable<BaseResponse> rx_getProvinceData() {
        return API_Factory.rx_getProvinceData(new BaseRequest());
    }
}
