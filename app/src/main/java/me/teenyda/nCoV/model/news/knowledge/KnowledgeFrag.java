package me.teenyda.nCoV.model.news.knowledge;

import android.content.Context;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.news.knowledge.model.IKnowledgeModel;
import me.teenyda.nCoV.model.news.knowledge.presenter.KnowledgePresenter;
import me.teenyda.nCoV.model.news.knowledge.view.IKnowledgeView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class KnowledgeFrag extends MvpFragment<IKnowledgeView,IKnowledgeModel,KnowledgePresenter> implements IKnowledgeView{

    @Override
    protected KnowledgePresenter initPresenter() {
        return new KnowledgePresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_knowledge;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void doBuseness() {

    }

    @Override
    public Context getMContext() {
        return getContext();
    }
}
