package me.teenyda.nCoV.model.query.base.presenter;

import com.alibaba.fastjson.JSON;
import com.orhanobut.logger.Logger;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import me.teenyda.nCoV.base.entity.request.QueryReq;
import me.teenyda.nCoV.base.entity.response.NcovSameEntity;
import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.base.net.BaseRequest;
import me.teenyda.nCoV.base.net.BaseResponse;
import me.teenyda.nCoV.model.query.base.model.IQueryModel;
import me.teenyda.nCoV.model.query.base.model.QueryModelImpl;
import me.teenyda.nCoV.model.query.base.view.IQueryView;

public class QueryPresenter extends BasePresenter<IQueryView, IQueryModel> {

    public QueryPresenter() {
        mModel = new QueryModelImpl();
    }

    public void query(QueryReq req) {
        mModel.queryData(req)
                .doOnSubscribe(disposable -> {
                    showLoading();
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .map(baseResponse -> {
                    String data = baseResponse.data;
                    Logger.json(data);
                    List<NcovSameEntity> ncovSameEntities = JSON.parseArray(data, NcovSameEntity.class);
                    return ncovSameEntities;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<NcovSameEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<NcovSameEntity> ncovSameEntity) {
                        mView.setncovSameData(ncovSameEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        hideLoading();
                    }
                });
    }
}
