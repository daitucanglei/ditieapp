package com.example.lsm;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
public class RvAdapter extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_adapter);
        // 实例化
        mWebView = (WebView) findViewById(R.id.mWebView);

        // 开启javascript 渲染
      /*  mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
               mWebView.loadUrl("file:///assets/api1.html");
                return true;
            }
        });*/
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());

        // 载入内容
        mWebView.loadUrl("file:///android_asset/api1.html");
  // mWebView.loadUrl("https://www.baidu.com");

    }
}