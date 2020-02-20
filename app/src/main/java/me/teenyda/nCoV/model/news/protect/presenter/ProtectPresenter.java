package me.teenyda.nCoV.model.news.protect.presenter;

import com.alibaba.fastjson.JSON;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.teenyda.nCoV.base.entity.RumorEntity;
import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.news.protect.model.IProtectModel;
import me.teenyda.nCoV.model.news.protect.model.ProtectModelImpl;
import me.teenyda.nCoV.model.news.protect.view.IProtectView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class ProtectPresenter extends BasePresenter<IProtectView, IProtectModel> {

    public ProtectPresenter() {
        mModel = new ProtectModelImpl();
    }

    public void getProvinceData() {
        mModel.rx_getRumorList()
                .doOnSubscribe(disposable -> {

                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .map(baseResponse -> {
                    List<RumorEntity> rumorEntities = JSON.parseArray(baseResponse.data, RumorEntity.class);
                    return rumorEntities;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<RumorEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<RumorEntity> rumorEntities) {
                        mView.setRumor(rumorEntities);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
