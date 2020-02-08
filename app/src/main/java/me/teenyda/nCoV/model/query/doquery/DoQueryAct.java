package me.teenyda.nCoV.model.query.doquery;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpActivity;
import me.teenyda.nCoV.model.query.doquery.model.IDoQueryModel;
import me.teenyda.nCoV.model.query.doquery.presenter.DoQueryPresenter;
import me.teenyda.nCoV.model.query.doquery.view.IDoQueryView;

/**
 * author: teenyda
 * date: 2020/2/8
 * description:
 */
public class DoQueryAct extends MvpActivity<IDoQueryView, IDoQueryModel, DoQueryPresenter> implements IDoQueryView {

    private LinearLayout doquery_back_ll;

    @Override
    protected DoQueryPresenter initPresenter() {
        return new DoQueryPresenter();
    }

    @Override
    protected void doBuseness() {

    }

    @Override
    protected int setR_layout() {
        return R.layout.act_doquery;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void initView() {
        doquery_back_ll = (LinearLayout) $(R.id.doquery_back_ll);
        doquery_back_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public Context getMContext() {
        return this;
    }
}
