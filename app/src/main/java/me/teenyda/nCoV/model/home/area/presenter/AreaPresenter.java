package me.teenyda.nCoV.model.home.area.presenter;

import com.alibaba.fastjson.JSON;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.teenyda.nCoV.base.entity.ProvinceDataEntity;
import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.home.area.model.AreaModelImpl;
import me.teenyda.nCoV.model.home.area.model.IAreaModel;
import me.teenyda.nCoV.model.home.area.view.IAreaView;

/**
 * author: teenyda
 * date: 2020/2/6
 * description:
 */
public class AreaPresenter extends BasePresenter<IAreaView, IAreaModel> {

    public AreaPresenter() {
        mModel = new AreaModelImpl();
    }

    /**
     * 获取省份数据
     */
    public void getProvinceData() {
        mModel.rx_getProvinceData()
                .doOnSubscribe(disposable -> {

                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .map(baseResponse -> {
                    List<ProvinceDataEntity> provinceDataEntities = JSON.parseArray(baseResponse.data, ProvinceDataEntity.class);
                    return provinceDataEntities;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ProvinceDataEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ProvinceDataEntity> provinceList) {
                        mView.setProvinceData(provinceList);
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
