package me.teenyda.nCoV.model.news.broadcast;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.news.broadcast.adapter.BroadcastAdapter;
import me.teenyda.nCoV.model.news.broadcast.model.IBroadcastModel;
import me.teenyda.nCoV.model.news.broadcast.presenter.BroadcastPresenter;
import me.teenyda.nCoV.model.news.broadcast.view.IBroadcastView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class BroadcastFrag extends MvpFragment<IBroadcastView,IBroadcastModel,BroadcastPresenter> implements IBroadcastView {

    private RecyclerView broadcast_rv;

    public static BroadcastFrag getInstance() {
        BroadcastFrag frag = new BroadcastFrag();
        return frag;
    }

    @Override
    protected BroadcastPresenter initPresenter() {
        return new BroadcastPresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_broadcast;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void initView() {
        broadcast_rv = (RecyclerView) $(R.id.broadcast_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getMContext());
        broadcast_rv.setLayoutManager(manager);
        BroadcastAdapter adapter = new BroadcastAdapter(getMContext());
        broadcast_rv.setAdapter(adapter);

    }

    @Override
    protected void doBuseness() {

    }

    @Override
    public Context getMContext() {
        return getContext();
    }
}
