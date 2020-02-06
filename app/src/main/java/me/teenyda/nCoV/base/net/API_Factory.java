package me.teenyda.nCoV.base.net;

import io.reactivex.Observable;

public class API_Factory {

    public static Observable<BaseResponse> rx_getBookList(BaseRequest baseRequest) {
        return RXNetApi.quackQuery(baseRequest, RXNetApi.Type.GET, NET_URL.get_book_list, BaseResponse.class);
    }
}
