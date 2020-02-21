package me.teenyda.nCoV.base.mvp;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.Toast;

public abstract class MvpActivity<V extends BaseView, M, P extends BasePresenter> extends BaseActivity {

    protected P mPresenter;

    protected Toast T;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
        mPresenter.attach((V) this);
        super.onCreate(savedInstanceState);
    }

    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }

    protected void showShort(String msg) {
        if (T != null) {
            T.setText(msg);
        } else {
            T = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        }

        T.show();
    }
}
