package me.teenyda.nCoV.base.view.popview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AlertDialog;

import me.teenyda.nCoV.R;

public class LoadingDialog {

    private static AlertDialog mDialog;

    public static AlertDialog getNewDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.pop_loading, null, false);
        builder.setView(view);
        return mDialog = builder.create();
    }

    public static AlertDialog getDialog() {
        return mDialog;
    }
}
