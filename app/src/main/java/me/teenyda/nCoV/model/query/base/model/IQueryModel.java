package me.teenyda.nCoV.model.query.base.model;

import io.reactivex.Observable;
import me.teenyda.nCoV.base.net.BaseRequest;
import me.teenyda.nCoV.base.net.BaseResponse;

public interface IQueryModel {

    Observable<BaseResponse> queryData(BaseRequest request);
}
