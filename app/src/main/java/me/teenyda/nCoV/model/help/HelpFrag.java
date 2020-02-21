package me.teenyda.nCoV.model.help;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpFragment;
import me.teenyda.nCoV.model.help.model.IHelpModel;
import me.teenyda.nCoV.model.help.presenter.HelpPresenter;
import me.teenyda.nCoV.model.help.view.IHelpView;

public class HelpFrag extends MvpFragment<IHelpView, IHelpModel, HelpPresenter> implements IHelpView {
    @Override
    protected HelpPresenter initPresenter() {
        return new HelpPresenter();
    }

    @Override
    protected int setR_layout() {
        return R.layout.frag_my;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void doBuseness() {
        $(R.id.open_dxy).setOnClickListener(v -> {
            Uri uri = Uri.parse("https://ncov.dxy.cn/ncovh5/view/pneumonia");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        $(R.id.open_git).setOnClickListener(v -> {
            Uri uri = Uri.parse("https://github.com/teenyda/ncov");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }

    @Override
    public Context getMContext() {
        return getContext();
    }
}
