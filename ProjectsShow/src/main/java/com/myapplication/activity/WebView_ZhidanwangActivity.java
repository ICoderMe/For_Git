package com.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;
import com.myapplication.R;

/**
 * Created by lenovo on 2016/8/31.
 */
public class WebView_ZhidanwangActivity extends Activity {
    private WebView webView;
    private CircleProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_zhioa);
        progressBar = (CircleProgressBar) findViewById(R.id.progressBar);


        webView = (WebView) findViewById(R.id.id_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setUseWideViewPort(true);  //将图片调整到适合webview的大小
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        webSettings.setDefaultTextEncodingName("utf-8");

        // 设置可以支持缩放
        webView.getSettings().setSupportZoom(false);
        //为图片添加放大缩小功能
        webView.getSettings().setUseWideViewPort(false);
        // 从assets目录下面的加载html
//        InsertObj obj = new InsertObj(this, webView);
//        webView.addJavascriptInterface(obj, "jsObj");

        progressBar.setProgress(0);

        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webView.loadUrl("http://zhidan.info");


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebChromeClient mWebChromeClient = new WebChromeClient() {

            //获得网页的加载进度，显示在右上角的TextView控件中
            @Override
            public void onProgressChanged(WebView view, final int newProgress) {
                if (newProgress < 100) {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                } else {
                    progressBar.setProgress(100);
                    progressBar.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);
                }
            }
        };
        webView.setWebChromeClient(mWebChromeClient);
    }

}
