package me.teenyda.nCoV.model.news.protect;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.RumorEntity;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.news.protect.adapter.ProtectAdapter;
import me.teenyda.nCoV.model.news.protect.model.IProtectModel;
import me.teenyda.nCoV.model.news.protect.presenter.ProtectPresenter;
import me.teenyda.nCoV.model.news.protect.view.IProtectView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description: 辟谣与防护
 */
public class ProtectFrag extends MvpFragment<IProtectView,IProtectModel,ProtectPresenter> implements IProtectView{

    private RecyclerView mRecyclerView;
    private ProtectAdapter adapter;

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

        adapter = new ProtectAdapter(getMContext());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void doBuseness() {
        mPresenter.getProvinceData();
    }

    @Override
    public Context getMContext() {
        return getContext();
    }

    @Override
    public void setRumor(List<RumorEntity> rumors) {
        adapter.setData(rumors);
    }
}
