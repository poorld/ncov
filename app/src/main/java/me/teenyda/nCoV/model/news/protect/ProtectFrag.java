package me.teenyda.nCoV.model.news.protect;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.news.protect.adapter.ProtectAdapter;
import me.teenyda.nCoV.model.news.protect.model.IProtectModel;
import me.teenyda.nCoV.model.news.protect.presenter.ProtectPresenter;
import me.teenyda.nCoV.model.news.protect.view.IProtectView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class ProtectFrag extends MvpFragment<IProtectView,IProtectModel,ProtectPresenter> implements IProtectView{

    private RecyclerView mRecyclerView;

    public static Fragment getInstance() {
        ProtectFrag frag = new ProtectFrag();
//        Bundle bundle = frag.getArguments();
//        bundle.putString();
        return frag;
    }

    @Override
    protected ProtectPresenter initPresenter() {
        return new ProtectPresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_protect;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) $(R.id.protect_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getMContext());
        mRecyclerView.setLayoutManager(manager);

        ProtectAdapter adapter = new ProtectAdapter(getMContext());
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
