package me.teenyda.nCoV.model.news.knowledge.presenter;

import com.alibaba.fastjson.JSON;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.teenyda.nCoV.base.entity.BroadcastEntity;
import me.teenyda.nCoV.base.entity.KnowledgeEntity;
import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.news.knowledge.model.IKnowledgeModel;
import me.teenyda.nCoV.model.news.knowledge.model.KnowledgeModelImpl;
import me.teenyda.nCoV.model.news.knowledge.view.IKnowledgeView;
import me.teenyda.nCoV.model.news.protect.model.IProtectModel;
import me.teenyda.nCoV.model.news.protect.model.ProtectModelImpl;
import me.teenyda.nCoV.model.news.protect.view.IProtectView;

/**
 * author: teenyda
 * date: 2020/2/7
 * description:
 */
public class KnowledgePresenter extends BasePresenter<IKnowledgeView, IKnowledgeModel> {

    public KnowledgePresenter() {
        mModel = new KnowledgeModelImpl();
    }


    public void getKnowledge() {
        mModel.rx_getKnowledge()
                .doOnSubscribe(disposable -> {
                    showLoading();
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .map(baseResponse -> {
                    List<KnowledgeEntity> knowledgeEntities = JSON.parseArray(baseResponse.data, KnowledgeEntity.class);
                    return knowledgeEntities;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<KnowledgeEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<KnowledgeEntity> knowledgeEntities) {
                        mView.setKnowledge(knowledgeEntities);
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
