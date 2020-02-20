package me.teenyda.nCoV.model.home.base.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.orhanobut.logger.Logger;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import me.teenyda.nCoV.base.entity.BookEntity;
import me.teenyda.nCoV.base.entity.ProvinceDataEntity;
import me.teenyda.nCoV.base.entity.StatisticsEntity;
import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.base.net.BaseResponse;
import me.teenyda.nCoV.model.home.base.model.HomeModelImpl;
import me.teenyda.nCoV.model.home.base.model.IHomeModel;
import me.teenyda.nCoV.model.home.base.view.IHomeView;

public class HomePresenter extends BasePresenter<IHomeView, IHomeModel> {

    public HomePresenter() {
        mModel = new HomeModelImpl();
    }

    public void initData() {
        mModel.rx_initData()
                .doOnSubscribe(disposable -> {

                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .map((Function<BaseResponse, Integer>) baseResponse -> {
                    String data = baseResponse.data;
                    Logger.json(data);
                    return Integer.valueOf(baseResponse.code);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer code) {
                        if (code == 200) {
                            getData();
                            getProvinceData();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 获取患者人数
     */
    public void getData() {
        mModel.rx_getIndexData()
                .doOnSubscribe(disposable -> {

                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .map(baseResponse -> {
                    StatisticsEntity statisticsEntity = JSON.parseObject(baseResponse.data, StatisticsEntity.class);
                    return statisticsEntity;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StatisticsEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StatisticsEntity statisticsEntity) {
                        //现存
                        mView.setData(statisticsEntity);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
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
                        mView.setProvinceData(provinceList, false);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getBookList() {
        mModel.rx_getBookList()
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (!disposable.isDisposed()) {

                        }
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .map(baseResponse -> {
                    BookEntity bookEntity = JSON.parseObject(baseResponse.data, BookEntity.class);
                    return bookEntity;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BookEntity bookEntity) {
                        mView.setBook(bookEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
