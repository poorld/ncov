package me.teenyda.nCoV.model.query.doquery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orhanobut.logger.Logger;


import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpActivity;
import me.teenyda.nCoV.base.tools.TimeUtils;
import me.teenyda.nCoV.base.view.popview.DateSelectorPopView;
import me.teenyda.nCoV.model.query.doquery.adapter.TypeAdapter;
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

    private TextView doquery_tv;

    private DateSelectorPopView dateSelectorPopView;

    private EditText query_et_date;
    private EditText query_no;
    private EditText query_arrive;
    private int selectType = 1;

    private RecyclerView doquery_rv;

    public static final int requestCode = 10001;
    public static final int resultCode = 10002;
    public static final int failResultCode = 10003;



    public static void startDoQueryAct(Context context) {
        Intent intent = new Intent(context, DoQueryAct.class);
        context.startActivity(intent);
        ((Activity)context).startActivityForResult(intent, requestCode);
    }

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
        Logger.d("onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d("onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d("onDestroy()");
    }

    @Override
    protected void initView() {
        dateSelectorPopView = new DateSelectorPopView(getMContext(), (date, v) -> {
            String ytd = TimeUtils.getYTD(date);
            query_et_date.setText(ytd);
        });
        query_et_date = (EditText) $(R.id.query_et_date);
        query_no = (EditText) $(R.id.query_no);
        query_arrive = (EditText) $(R.id.query_arrive);

        doquery_back_ll = (LinearLayout) $(R.id.doquery_back_ll);
        doquery_back_ll.setOnClickListener(v -> {
            setResult(failResultCode);
            finish();
        });

        doquery_rv = (RecyclerView) $(R.id.doquery_rv);
        TypeAdapter adapter = new TypeAdapter(getMContext());
        LinearLayoutManager manager = new LinearLayoutManager(getMContext());
        doquery_rv.setLayoutManager(manager);
        doquery_rv.setAdapter(adapter);
        adapter.setItemClickListener(type -> {
            selectType = type;
        });

        doquery_tv = (TextView) $(R.id.doquery_tv);
        //查询
        doquery_tv.setOnClickListener(view -> {
            String date = query_et_date.getText().toString();
            String no = query_no.getText().toString();
            String arrive = query_arrive.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("date", date);
            intent.putExtra("no", no);
            intent.putExtra("arrive", arrive);
            intent.putExtra("type", String.valueOf(selectType));

            setResult(resultCode, intent);
            finish();
        });
        query_et_date.setOnClickListener(v -> dateSelectorPopView.show(v));
    }

    @Override
    public Context getMContext() {
        return this;
    }


}
