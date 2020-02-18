package me.teenyda.nCoV.model.query.base.model;

import io.reactivex.Observable;
import me.teenyda.nCoV.base.net.API_Factory;
import me.teenyda.nCoV.base.net.BaseRequest;
import me.teenyda.nCoV.base.net.BaseResponse;

public class QueryModelImpl implements IQueryModel {

    @Override
    public Observable<BaseResponse> queryData(BaseRequest request) {
        return API_Factory.rx_getnCoVsame(request);
    }

}
