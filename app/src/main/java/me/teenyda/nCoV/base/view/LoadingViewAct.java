package me.teenyda.nCoV.base.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MyApplication;

public class LoadingViewAct extends AppCompatActivity {

    private static Activity mActivity;

    public static void showLoading() {
        Context context = MyApplication.getInstance();
        Intent intent = new Intent(context, LoadingViewAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void hideLoading() {
        mActivity.finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.pop_loading);
        findViewById(R.id.loading_out)
                .setOnClickListener(v -> finish());

        mActivity = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
