package me.teenyda.nCoV.base.mvp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.teenyda.nCoV.R;


public abstract class BaseActivity extends AppCompatActivity {

    private View mContentView;

    private static final String ACTION_EXIT = "APP_EXIT";

    protected boolean marginStateBar = true;

    protected LocalBroadcastManager mBroadcastManager;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case ACTION_EXIT:
                    ApplicationManager.finishedAll();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContentView = LayoutInflater.from(this).inflate(setR_layout(), null, false);
        setContentView(mContentView);
        // 禁止屏幕旋转
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ApplicationManager.addActivity(this);
        registerBroadcast();
        initialize();
        initView();
        doBuseness();
    }

    protected abstract void doBuseness();

    protected void setTitle(String title) {
        TextView titleTv = (TextView) $(R.id.tv_include_title);
        if (titleTv != null) {
            titleTv.setText(title);
        }
    }

    protected void setBack() {
        RelativeLayout back = (RelativeLayout) $(R.id.rl_title_back);
        if (back != null) {
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    protected abstract int setR_layout();

    protected abstract void initialize();

    protected abstract void initView();

    /**
     * 注册广播
     */
    private void registerBroadcast() {
        mBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_EXIT);
        mBroadcastManager.registerReceiver(mBroadcastReceiver, intentFilter);
    }

    /**
     * 获取状态栏高度 默认给个20
     * @return
     */
    private int getStateBar() {
        int result = 20;
        int resourceId = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = this.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    protected View $(int id){
        return findViewById(id);
    }

    protected void toActivity(Class<Activity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    protected void toActivity(Class<?> clazz, Bundle args){
        toActivity(clazz, args, false);
    }

    protected void toActivity(Class<?> clazz, Bundle args, boolean isCloseAct) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(args);
        startActivity(intent);
        if (isCloseAct) {
            finish();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBroadcastManager.unregisterReceiver(mBroadcastReceiver);
        ApplicationManager.removeActivity(this);
    }
}
