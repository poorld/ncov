package me.teenyda.nCoV.model.query.doquery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orhanobut.logger.Logger;


import java.util.Map;

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
    private TextView doquery_reset;

    private DateSelectorPopView dateSelectorPopView;

    private EditText query_et_date;
    private EditText query_no;
    private EditText query_arrive;
    private String date;
    private String no;
    private String arrive;
    private int type = 1;

    private RecyclerView doquery_rv;

    public static final int requestCode = 10001;
    public static final int resultCode = 10002;
    public static final int failResultCode = 10003;




    public static void startDoQueryAct(Context context, Map<String,String> datas) {
        Intent intent = new Intent(context, DoQueryAct.class);
        intent.putExtra("date", datas.get("date"));
        intent.putExtra("no", datas.get("no"));
        intent.putExtra("arrive", datas.get("arrive"));
        intent.putExtra("type", datas.get("type"));
//        context.startActivity(intent);
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
        Intent intent = getIntent();
        date = intent.getStringExtra("date");
        no = intent.getStringExtra("no");
        arrive = intent.getStringExtra("arrive");
        String type1 = intent.getStringExtra("type");
        if (!TextUtils.isEmpty(type1)) {
            this.type = Integer.parseInt(type1);
        }
        Logger.d("onCreate()");
    }


    @Override
    protected void initView() {

        // 日期选择弹窗
        dateSelectorPopView = new DateSelectorPopView(getMContext(), (date, v) -> {
            String ytd = TimeUtils.getYTD(date);
            query_et_date.setText(ytd);
        });

        query_et_date = (EditText) $(R.id.query_et_date);
        query_no = (EditText) $(R.id.query_no);
        query_arrive = (EditText) $(R.id.query_arrive);
        if (!TextUtils.isEmpty(date)) {
            query_et_date.setText(date);
            dateSelectorPopView.setDate(date);
        }
        if (!TextUtils.isEmpty(no)) {
            query_no.setText(no);
        }
        if (!TextUtils.isEmpty(arrive)) {
            query_arrive.setText(arrive);
        }



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
            this.type = type;
        });
        adapter.setType(type);

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
            intent.putExtra("type", String.valueOf(type));

            setResult(resultCode, intent);
            finish();
        });
        query_et_date.setOnClickListener(v -> dateSelectorPopView.show(v));

        //重置
        doquery_reset = (TextView) $(R.id.doquery_reset);
        doquery_reset.setOnClickListener(v -> {
            query_et_date.setText("");
            query_no.setText("");
            query_arrive.setText("");
            adapter.setType(1);
            dateSelectorPopView.setDate(TimeUtils.getYTD());
        });
    }

    @Override
    public Context getMContext() {
        return this;
    }


}
