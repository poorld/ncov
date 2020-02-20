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

    /**
     * 初始化数据
     * @param baseRequest
     * @return
     */
    public static Observable<BaseResponse> rx_initData(BaseRequest baseRequest) {
        return RXNetApi.quackGet(baseRequest, NET_URL.get_init_data);
    }

    /**
     * 首页数据(幻灯片，患者人数等)
     * @param baseRequest
     * @return
     */
    public static Observable<BaseResponse> rx_getIndexData(BaseRequest baseRequest) {
        return RXNetApi.quackGet(baseRequest, NET_URL.get_index_data);
    }

    /**
     * 省份数据
     * @param baseRequest
     * @return
     */
    public static Observable<BaseResponse> rx_getProvinceData(BaseRequest baseRequest) {
        return RXNetApi.quackGet(baseRequest, NET_URL.get_province_data);
    }

    /**
     * 谣言
     * @param baseRequest
     * @return
     */
    public static Observable<BaseResponse> rx_getIndexRumorList(BaseRequest baseRequest) {
        return RXNetApi.quackGet(baseRequest, NET_URL.get_rumor_list);
    }

    /**
     * 实时播报
     * @param baseRequest
     * @return
     */
    public static Observable<BaseResponse> rx_getBroadcast(BaseRequest baseRequest) {
        return RXNetApi.quackGet(baseRequest, NET_URL.get_broadcast);
    }

    /**
     * 疾病知识
     * @param baseRequest
     * @return
     */
    public static Observable<BaseResponse> rx_getKnowledge(BaseRequest baseRequest) {
        return RXNetApi.quackGet(baseRequest, NET_URL.get_knowledge);
    }


}
