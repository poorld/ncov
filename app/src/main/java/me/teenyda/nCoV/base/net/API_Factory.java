package me.teenyda.nCoV.base.net;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class API_Factory {

    public static Observable<BaseResponse> rx_getBookList(BaseRequest baseRequest) {
        return RXNetApi.quackGet(baseRequest, NET_URL.get_book_list);
    }

    /**
     * 天行数据 肺炎同程查询
     * @param baseRequest
     * @return
     */
    public static Observable<BaseResponse> rx_getnCoVsame(BaseRequest baseRequest) {
        Map<String, String> respParam = new HashMap<>();
        respParam.put("code", "code");
        respParam.put("message", "msg");
        respParam.put("data", "newslist");
        return RXNetApi.otherQuery(baseRequest, RXNetApi.Type.GET, NET_URL.TIANXING_URL, BaseResponse.class, respParam);
    }
}
