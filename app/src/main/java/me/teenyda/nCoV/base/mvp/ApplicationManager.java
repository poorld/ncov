package me.teenyda.nCoV.base.mvp;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {

    private static List<Activity> mActivities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        mActivities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        mActivities.remove(activity);
    }

    public static Activity getActivity() {
        return mActivities.get(mActivities.size() - 1);
    }

    public static void finishedAll() {
        for (Activity activity : mActivities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
