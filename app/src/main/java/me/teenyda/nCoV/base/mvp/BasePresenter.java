package me.teenyda.nCoV.base.mvp;

import android.content.Context;
import android.os.CountDownTimer;

import androidx.appcompat.app.AlertDialog;

import me.teenyda.nCoV.base.view.popview.LoadingDialog;

public class BasePresenter<V extends BaseView, M> {

    protected V mView;
    protected Context mContext;
    protected M mModel;

    private boolean overtime = false;
    private boolean loadFinished = false;

    private CountDownTimer timer = new CountDownTimer(1000, 500) {
        @Override
        public void onTick(long millisUntilFinished) {
            overtime = false;
            loadFinished = false;
        }

        @Override
        public void onFinish() {
            overtime = true;
            if (loadFinished) {
                dialog.dismiss();
            }
        }
    };
    private AlertDialog dialog;

    public void attach(V view) {
        this.mView = view;
        mContext = mView.getMContext();
    }

    public void unbind() {
        this.mView = null;
        mContext = null;
        timer.cancel();
        timer = null;
    }

    public void showLoading(){
        dialog = LoadingDialog.getDialog(mContext);
        dialog.show();
        timer.start();

    }

    /**
     * 情况1：1秒内完成加载，等到1秒隐藏
     * loadFinished = true
     *
     * 情况2：1秒内未完成加载，加载完成立刻隐藏
     * overtime = true;
     */
    public synchronized void hideLoading() {
        loadFinished = true;
        if (overtime) {
            dialog.dismiss();
        }

    }


}
