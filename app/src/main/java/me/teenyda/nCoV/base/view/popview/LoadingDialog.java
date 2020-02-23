package me.teenyda.nCoV.base.view.popview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;

import me.teenyda.nCoV.R;

public class LoadingDialog {

    private static AlertDialog mDialog;

    private static Context mContext;

    private static void getNewDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.pop_loading, null, false);
        builder.setView(view);
        mDialog = builder.create();
        mDialog.setOnDismissListener(dialog -> backgroundAlpha(1f));
    }

    public static AlertDialog getDialog(Context context) {
        if (mContext != null && mContext == context) {
            return mDialog;
        }
        mContext = context;
        getNewDialog();
        return mDialog;
    }

    public static void dismiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }


    private static void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
        lp.alpha = bgAlpha;
        ((Activity) mContext).getWindow().setAttributes(lp);
    }
}
