package me.teenyda.nCoV.base.view.popview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import me.teenyda.nCoV.R;

/**
 * getDialog(View v) 怎么获取view都有错，或者空指针，暂时用AlertDialog{@link LoadingDialog}
 *
 */
public class LoadingPopView {
    private static Context mContext;
    private PopupWindow mPopupWindow;
    private View mView;
    private static LoadingPopView mInstance;

    public LoadingPopView(Context context) {
        mContext = context;
        initPopView();
    }

    public static LoadingPopView getInstance(Context context) {
        mContext = context;
        synchronized (LoadingPopView.class) {
            if (mInstance == null) {
                return mInstance = new LoadingPopView(mContext);
            }
            return mInstance;
        }
    }


    private void initPopView() {
        mView = LayoutInflater.from(mContext).inflate(R.layout.pop_loading, null, false);
        mPopupWindow = new PopupWindow(mView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        mPopupWindow.setOnDismissListener(() -> backgroundAlpha(1f));
    }

    public void show(View v) {
        // setFocusable 默认是false
        // setFocusable(true)外部和内部都会响应，点击外部就会取消，setOutsideTouchable(false)失效
        mPopupWindow.setFocusable(true);
        // 设置PopupWindow是否能响应点击事件
        mPopupWindow.setTouchable(true);
        // 设置PopupWindow内容区域外的区域是否响应点击事件（true：响应；false：不响应）
        mPopupWindow.setOutsideTouchable(true);

        mPopupWindow.showAtLocation(v, Gravity.CENTER, 0 , 0);
//        backgroundAlpha(0.5f);
    }

    public void dismiss() {
        mPopupWindow.dismiss();
    }

    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
        lp.alpha = bgAlpha;
        ((Activity) mContext).getWindow().setAttributes(lp);
    }
}
