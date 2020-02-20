package me.teenyda.nCoV.model.news.knowledge.model;

import io.reactivex.Observable;
import me.teenyda.nCoV.base.net.API_Factory;
import me.teenyda.nCoV.base.net.BaseRequest;
import me.teenyda.nCoV.base.net.BaseResponse;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class KnowledgeModelImpl implements IKnowledgeModel {
    @Override
    public Observable<BaseResponse> rx_getKnowledge() {
        return API_Factory.rx_getKnowledge(new BaseRequest());
    }
}
