package me.teenyda.nCoV.model.home.area.model;

import io.reactivex.Observable;
import me.teenyda.nCoV.base.net.BaseResponse;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public interface IAreaModel {

    Observable<BaseResponse> rx_getProvinceData();
}
