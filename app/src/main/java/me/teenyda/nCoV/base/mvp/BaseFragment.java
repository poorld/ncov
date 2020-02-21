package me.teenyda.nCoV.base.mvp;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.teenyda.nCoV.R;

public abstract class BaseFragment extends Fragment {

    protected View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = LayoutInflater.from(getContext()).inflate(setR_layout(), container, false);
        this.mView = contentView;
        initialize();
        initView();
        doBuseness();
        return contentView;
    }

    protected void setTitle(String title) {
        TextView titleTv = mView.findViewById(R.id.tv_include_title);
        if (titleTv != null) {
            titleTv.setText(title);
        }
    }

    protected void setTitle(String title, int color) {
        TextView titleTv = mView.findViewById(R.id.tv_include_title);
        if (titleTv != null) {
            titleTv.setText(title);
            titleTv.setTextColor(color);
        }
    }

    protected abstract int setR_layout();

    protected abstract void initialize();

    protected abstract void initView();

    /**
     * 网络请求
     */
    protected abstract void doBuseness();


    protected View $(int id) {
        return mView.findViewById(id);
    }

    protected void toActivity(Class clazz) {
        Intent intent = new Intent(getContext(), clazz);
        startActivity(intent);
    }

    protected void toActivity(Class clazz, Bundle args){
        toActivity(clazz, args, false);
    }

    protected void toActivity(Class clazz, Bundle args, boolean isCloseAct) {
        Intent intent = new Intent(getContext(), clazz);
        intent.putExtras(args);
        startActivity(intent);
    }
}
