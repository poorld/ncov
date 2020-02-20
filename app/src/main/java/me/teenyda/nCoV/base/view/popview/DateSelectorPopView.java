package me.teenyda.nCoV.base.view.popview;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;


import java.util.Calendar;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.tools.TimeUtils;


public class DateSelectorPopView {


    private Context mContext;
    private TimePickerView timePickerView;
    private OnTimeSelectListener mOnTimeSelectListener;


    public DateSelectorPopView(Context context, OnTimeSelectListener onTimeSelectListener) {
        mContext = context;
        mOnTimeSelectListener = onTimeSelectListener;
        initPopView();
    }

    public void setDate(String date) {
        Calendar calendar = TimeUtils.getCalendar(date, TimeUtils.datePattern2);
        timePickerView.setDate(calendar);
    }

    private void initPopView() {
        timePickerView = new TimePickerBuilder(mContext,mOnTimeSelectListener)
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setContentTextSize(18)//滚轮文字大小
                .setTitleSize(20)//标题文字大小
                .setTitleText("选择日期")//标题文字
                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTitleColor(mContext.getResources().getColor(R.color.c_2c2c2c))//标题文字颜色
                .setSubmitColor(mContext.getResources().getColor(R.color.c_414141))//确定按钮文字颜色
                .setCancelColor(mContext.getResources().getColor(R.color.c_414141))//取消按钮文字颜色
                .setTitleBgColor(mContext.getResources().getColor(R.color.c_adadad))//标题背景颜色 Night mode
                .setBgColor(mContext.getResources().getColor(R.color.c_ffffff))//滚轮背景颜色 Night mode
                .setTextColorCenter(mContext.getResources().getColor(R.color.c_5866fa))
                //.setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                //.setRangDate(startDate,endDate)//起始终止年月日设定
                .setLabel("年", "月", "日", "", "", "")//默认设置为年月日时分秒
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(true)//是否显示为对话框样式
                .build();
    }



    public void show(View v) {
        Dialog dialog = timePickerView.getDialog();
        if (dialog != null) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            timePickerView.getDialogContainerLayout().setLayoutParams(params);

            Window window = dialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                window.setGravity(Gravity.BOTTOM);
            }

        }
        timePickerView.show(v);
    }

    public void dismiss() {
        timePickerView.dismiss();
    }

}
