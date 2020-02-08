package me.teenyda.nCoV.model.news.knowledge;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.news.knowledge.adapter.KnowledgeAdapter;
import me.teenyda.nCoV.model.news.knowledge.model.IKnowledgeModel;
import me.teenyda.nCoV.model.news.knowledge.presenter.KnowledgePresenter;
import me.teenyda.nCoV.model.news.knowledge.view.IKnowledgeView;
import me.teenyda.nCoV.model.news.protect.adapter.ProtectAdapter;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class KnowledgeFrag extends MvpFragment<IKnowledgeView,IKnowledgeModel,KnowledgePresenter> implements IKnowledgeView{

    private RecyclerView knowledge_rv;

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

        KnowledgeAdapter adapter = new KnowledgeAdapter(getMContext());
        knowledge_rv.setAdapter(adapter);
    }

    @Override
    protected void doBuseness() {

    }

    @Override
    public Context getMContext() {
        return getContext();
    }
}
