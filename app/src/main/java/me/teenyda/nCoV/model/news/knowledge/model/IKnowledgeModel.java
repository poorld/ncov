package me.teenyda.nCoV.model.news.knowledge.model;

import io.reactivex.Observable;
import me.teenyda.nCoV.base.net.BaseResponse;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public interface IKnowledgeModel {

    Observable<BaseResponse> rx_getKnowledge();
}
