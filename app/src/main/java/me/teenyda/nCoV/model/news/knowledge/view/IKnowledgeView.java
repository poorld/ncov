package me.teenyda.nCoV.model.news.knowledge.view;

import java.util.List;

import me.teenyda.nCoV.base.entity.KnowledgeEntity;
import me.teenyda.nCoV.base.mvp.BaseView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public interface IKnowledgeView extends BaseView {

    void setKnowledge(List<KnowledgeEntity> knowledgeList);
}
