package me.teenyda.nCoV.model.home.base.presenter;

import com.alibaba.fastjson.JSON;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import me.teenyda.nCoV.base.entity.BookEntity;
import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.base.net.BaseResponse;
import me.teenyda.nCoV.model.home.base.model.HomeModelImpl;
import me.teenyda.nCoV.model.home.base.model.IHomeModel;
import me.teenyda.nCoV.model.home.base.view.IHomeView;

public class HomePresenter extends BasePresenter<IHomeView, IHomeModel> {

    public HomePresenter() {
        mModel = new HomeModelImpl();
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
                .map(new Function<BaseResponse, BookEntity>() {
                    @Override
                    public BookEntity apply(BaseResponse baseResponse) throws Exception {
                        BookEntity bookEntity = JSON.parseObject(baseResponse.data, BookEntity.class);
                        return bookEntity;
                    }
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
