package me.teenyda.nCoV.base.mvp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public abstract class MvpFragment<V extends BaseView, M, P extends BasePresenter> extends BaseFragment  {

    protected P mPresenter;

    protected Toast T;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mPresenter.attach((V)this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        mPresenter.unbind();
    }

    protected abstract P initPresenter();

    protected void showShort(String msg) {
        if (T != null) {
            T.setText(msg);
        } else {
            T = Toast.makeText(getContext() , msg, Toast.LENGTH_SHORT);
        }

        T.show();
    }
}
