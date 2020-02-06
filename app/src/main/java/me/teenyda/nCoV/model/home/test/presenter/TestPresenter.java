package me.teenyda.nCoV.model.home.test.presenter;

import me.teenyda.nCoV.base.mvp.BasePresenter;
import me.teenyda.nCoV.model.home.test.model.ITestModel;
import me.teenyda.nCoV.model.home.test.model.TestModelImpl;
import me.teenyda.nCoV.model.home.test.view.ITestView;

public class TestPresenter extends BasePresenter<ITestView, ITestModel> {

    public TestPresenter() {
        mModel = new TestModelImpl();
    }

    public void getBook(){

    }

}
