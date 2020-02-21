package me.teenyda.nCoV.model.news.broadcast.presenter;

import com.alibaba.fastjson.JSON;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.teenyda.nCoV.base.entity.BroadcastEntity;
import me.teenyda.nCoV.base.entity.RumorEntity;
import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.news.broadcast.model.BroadcastModelImpl;
import me.teenyda.nCoV.model.news.broadcast.model.IBroadcastModel;
import me.teenyda.nCoV.model.news.broadcast.view.IBroadcastView;
import me.teenyda.nCoV.model.news.protect.model.IProtectModel;
import me.teenyda.nCoV.model.news.protect.model.ProtectModelImpl;
import me.teenyda.nCoV.model.news.protect.view.IProtectView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class BroadcastPresenter extends BasePresenter<IBroadcastView, IBroadcastModel> {

    public BroadcastPresenter() {
        mModel = new BroadcastModelImpl();
    }

    public void getBroadcast() {
        mModel.rx_getBroadcast()
                .doOnSubscribe(disposable -> {
                    showLoading();
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .map(baseResponse -> {
                    List<BroadcastEntity> broadcastEntities = JSON.parseArray(baseResponse.data, BroadcastEntity.class);
                    return broadcastEntities;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BroadcastEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<BroadcastEntity> broadcastEntities) {
                        mView.setBroadcast(broadcastEntities);
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
