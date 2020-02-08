package me.teenyda.nCoV.model.query.base;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.query.base.adapter.QueryAdapter;
import me.teenyda.nCoV.model.query.base.model.IQueryModel;
import me.teenyda.nCoV.model.query.base.presenter.QueryPresenter;
import me.teenyda.nCoV.model.query.base.view.IQueryView;

public class QueryFragment extends MvpFragment<IQueryView, IQueryModel, QueryPresenter> implements IQueryView {

    RecyclerView mRecyclerView;


    @Override
    protected QueryPresenter initPresenter() {
        return new QueryPresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_message;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void initView() {
        setTitle("肺炎确诊患者同行程查询", getResources().getColor(R.color.c_ffffff));
        mRecyclerView = (RecyclerView) $(R.id.query_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getMContext());
        mRecyclerView.setLayoutManager(manager);

        QueryAdapter adapter = new QueryAdapter(getMContext());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void doBuseness() {

    }

    @Override
    public Context getMContext() {
        return getContext();
    }
}
