package me.teenyda.nCoV.model.query.doquery.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import me.teenyda.nCoV.base.entity.response.NcovSameEntity;
import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.base.net.BaseRequest;
import me.teenyda.nCoV.base.net.BaseResponse;
import me.teenyda.nCoV.model.query.doquery.model.IDoQueryModel;
import me.teenyda.nCoV.model.query.doquery.model.DoQueryModelImpl;
import me.teenyda.nCoV.model.query.doquery.view.IDoQueryView;

public class DoQueryPresenter extends BasePresenter<IDoQueryView, IDoQueryModel> {

    public DoQueryPresenter() {
        mModel = new DoQueryModelImpl();
    }


}
