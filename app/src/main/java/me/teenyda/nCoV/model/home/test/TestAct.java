package me.teenyda.nCoV.model.home.test;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.ApplicationManager;
import me.teenyda.nCoV.base.mvp.MvpActivity;
import me.teenyda.nCoV.base.view.popview.CommonPopView;
import me.teenyda.nCoV.model.home.test.model.ITestModel;
import me.teenyda.nCoV.model.home.test.presenter.TestPresenter;
import me.teenyda.nCoV.model.home.test.view.ITestView;

public class TestAct extends MvpActivity<ITestView, ITestModel, TestPresenter> implements ITestView {
    

    
      private TextView btn_test_logout;
     
      private CommonPopView mPopView;
     
      @Override
      protected TestPresenter initPresenter() {
          return new TestPresenter();
      }

        @Override
        protected void doBuseness() {

        }

        @Override
          protected int setR_layout() {
              return R.layout.act_test;
          }
     
          @Override
          protected void initialize() {
     
          }
     
          @Override
          protected void initView() {
              setTitle("测试哈哈");
              setBack();
     
              btn_test_logout = (TextView) $(R.id.btn_test_logout);
              mPopView = new CommonPopView(getMContext());
              mPopView.setTitle("提示")
                      .setLeftTitle("取消")
                      .setRightTitle("确定")
                      .setMessage("你好呀呀呀，我是垃圾垃圾，哈哈哈哈哈哈哈哈哈哈")
                      .setOnBtnClick(new CommonPopView.OnBtnClick() {
                          @Override
                          public void onLeftClick() {
                              mPopView.dismiss();
                          }
     
                          @Override
                          public void onRightClick() {
                              showShort("确定");
                              ApplicationManager.finishedAll();
                          }
                      });
              btn_test_logout.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      mPopView.show(v);
                  }
              });
     
          }
     
          @Override
          public Context getMContext() {
              return this;
          }

}
