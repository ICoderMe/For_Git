package com.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.myapplication.R;
import com.myapplication.utils.LogUtils;
import com.myapplication.utils.ToastHelper;

/**
 * Created by lenovo on 2016/8/31.
 */
public class WebViewActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);


        webView = (WebView) findViewById(R.id.id_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false); //支持通过JS打开新窗口
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setUseWideViewPort(true);  //将图片调整到适合webview的大小
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        webSettings.setDefaultTextEncodingName("utf-8");
        // 设置可以支持缩放
        webSettings.setSupportZoom(false);
        //为图片添加放大缩小功能
        webSettings.setUseWideViewPort(false);


        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        switch (id) {
            case 0://货运宝(货主端)
                webView.loadUrl("file:///android_asset/owner/jquerymobile.html");
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return false;
                    }

                });
                break;
            case 1://货运宝(司机端)
                webView.loadUrl("file:///android_asset/driver/index.html");
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return false;
                    }
                });
                break;
            case 2://智旦OA
                webView.loadUrl("file:///android_asset/zhioa/index.html");
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return false;
                    }
                });
                break;
            case 4://智部落(业主端)
                webView.loadUrl("file:///android_asset/zblyezhu/index.html");
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return false;
                    }
                });
                break;
            case 5://智部落(商铺端)
                webView.loadUrl("file:///android_asset/zblshop/index.html");
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return false;
                    }
                });
                break;
            case 6://智部落(物业管理)
                webView.loadUrl("file:///android_asset/zblguanli/index.html");
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return false;
                    }
                });
                break;
            case 7://智部落(物业调度)
                webView.loadUrl("file:///android_asset/zbldiaodu/index.html");
                //打开网页时不调用系统浏览器， 而是在本WebView中显示：
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return false;
                    }
                });
                break;
            case 8://送酒郎
                webView.loadUrl("file:///android_asset/songjiulang/index.html");
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return false;
                    }
                });
                break;
            case 9://智财宝
                webView.loadUrl("file:///android_asset/zhicaibao/index.html");
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        return false;
                    }
                });
                break;
            default:
                break;
        }
    }

    //效果为返回之前所有打开的界面,依次返回,
    @Override
    public void onBackPressed() {
//        if (webView.canGoBack()){
//            webView.goBack();
//            }else {
//               super.onBackPressed();
//            }
        super.onBackPressed();
    }
}
