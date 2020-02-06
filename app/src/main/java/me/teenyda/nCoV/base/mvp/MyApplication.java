package me.teenyda.nCoV.base.mvp;

import android.app.Application;

public class MyApplication {

    private static Application mApplication;

    public static Application getApplication() {

        synchronized (MyApplication.class) {
            if (mApplication == null) {
                return mApplication = new Application();
            } else {
                return mApplication;
            }
        }

    }
}
