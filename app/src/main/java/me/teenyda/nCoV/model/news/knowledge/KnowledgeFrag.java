package me.teenyda.nCoV.model.news.knowledge;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.KnowledgeEntity;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.news.knowledge.adapter.KnowledgeAdapter;
import me.teenyda.nCoV.model.news.knowledge.model.IKnowledgeModel;
import me.teenyda.nCoV.model.news.knowledge.presenter.KnowledgePresenter;
import me.teenyda.nCoV.model.news.knowledge.view.IKnowledgeView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description: 疾病知识
 */
public class KnowledgeFrag extends MvpFragment<IKnowledgeView,IKnowledgeModel,KnowledgePresenter> implements IKnowledgeView{

    private RecyclerView knowledge_rv;
    private KnowledgeAdapter adapter;

    public static KnowledgeFrag getInstance() {
        KnowledgeFrag frag = new KnowledgeFrag();
        return frag;
    }

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
        knowledge_rv = (RecyclerView) $(R.id.knowledge_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getMContext());
        knowledge_rv.setLayoutManager(manager);

        adapter = new KnowledgeAdapter(getMContext());
        knowledge_rv.setAdapter(adapter);
    }

    @Override
    protected void doBuseness() {
        mPresenter.getKnowledge();
    }

    @Override
    public Context getMContext() {
        return getContext();
    }

    @Override
    public void setKnowledge(List<KnowledgeEntity> knowledgeList) {
        knowledgeList.remove(0);
        adapter.setData(knowledgeList);
    }
}
