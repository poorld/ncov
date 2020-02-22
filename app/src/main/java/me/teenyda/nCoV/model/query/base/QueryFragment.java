package me.teenyda.nCoV.model.query.base;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.entity.request.QueryReq;
import me.teenyda.nCoV.base.entity.response.NcovSameEntity;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.query.base.adapter.QueryAdapter;
import me.teenyda.nCoV.model.query.base.model.IQueryModel;
import me.teenyda.nCoV.model.query.base.presenter.QueryPresenter;
import me.teenyda.nCoV.model.query.base.view.IQueryView;
import me.teenyda.nCoV.model.query.doquery.DoQueryAct;


public class QueryFragment extends MvpFragment<IQueryView, IQueryModel, QueryPresenter> implements IQueryView {

    private RecyclerView mRecyclerView;
    private QueryAdapter adapter;
    // 保存查询字段，打开查询页面填充进去
    public Map<String, String> resultData = new HashMap<>();


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
        setTitle("病患同行查询", getResources().getColor(R.color.c_ffffff));
        mRecyclerView = (RecyclerView) $(R.id.query_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getMContext());
        mRecyclerView.setLayoutManager(manager);

        adapter = new QueryAdapter(getMContext());
        mRecyclerView.setAdapter(adapter);

        $(R.id.bar_right_rl)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DoQueryAct.startDoQueryAct(getMContext(),resultData);
                    }
                });
    }

    @Override
    protected void doBuseness() {
        mPresenter.query(new QueryReq());
    }

    @Override
    public Context getMContext() {
        return getContext();
    }

    @Override
    public void setncovSameData(List<NcovSameEntity> ncovSames) {
        adapter.setData(ncovSames);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == DoQueryAct.requestCode) {
            if (resultCode == DoQueryAct.resultCode) {
                String date = data.getStringExtra("date");
                String no = data.getStringExtra("no");
                String arrive = data.getStringExtra("arrive");
                String type = data.getStringExtra("type");
                resultData.put("date", date);
                resultData.put("no", no);
                resultData.put("arrive", arrive);
                resultData.put("type", type);
                QueryReq req = new QueryReq();
                req.date = date;
                req.no = no;
                req.arrive = arrive;
                req.type = type;
                mPresenter.query(req);
            }
        }

    }
}
