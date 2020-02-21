package me.teenyda.nCoV.model.web;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import me.teenyda.nCoV.R;
import me.teenyda.nCoV.base.mvp.MvpActivity;
import me.teenyda.nCoV.model.web.model.IWebModel;
import me.teenyda.nCoV.model.web.presenter.WebPresenter;
import me.teenyda.nCoV.model.web.view.IWebView;

public class WebAct extends MvpActivity<IWebView, IWebModel, WebPresenter> implements IWebView {

    private WebView webview;

    private String mTiele;
    private String mUrl;

    public static void startWebAct(Context context, String title, String url) {
        Intent intent = new Intent(context, WebAct.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override
    protected WebPresenter initPresenter() {
        return new WebPresenter();
    }

    @Override
    protected void doBuseness() {

    }

    @Override
    protected int setR_layout() {
        return R.layout.act_web;
    }

    @Override
    protected void initialize() {
        Intent intent = getIntent();
        mTiele = intent.getStringExtra("title");
        mUrl = intent.getStringExtra("url");
    }

    @Override
    protected void initView() {
        setBack();

        webview = (WebView) $(R.id.webview);
        //支持javascript
        webview.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        webview.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        webview.getSettings().setBuiltInZoomControls(true);
        //扩大比例的缩放
        webview.getSettings().setUseWideViewPort(true);
        //自适应屏幕
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webview.getSettings().setLoadWithOverviewMode(true);
        if (!TextUtils.isEmpty(mTiele)) {
            setTitle(mTiele);
        }


        //如果不设置WebViewClient，请求会跳转系统浏览器
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //该方法在Build.VERSION_CODES.LOLLIPOP以前有效，从Build.VERSION_CODES.LOLLIPOP起，建议使用shouldOverrideUrlLoading(WebView, WebResourceRequest)} instead
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                //返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://ask.csdn.net/questions/178242

                if (!TextUtils.isEmpty(mUrl)) {
                    webview.loadUrl(mUrl);
                    return true;
                }

                return false;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
            {
                //返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
                //返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://ask.csdn.net/questions/178242
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (!TextUtils.isEmpty(mUrl)) {
                        webview.loadUrl(mUrl);
                        return true;
                    }
                }

                return false;
            }

        });
        webview.loadUrl(mUrl);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webview.destroy();
    }

    @Override
    public Context getMContext() {
        return this;
    }
}
