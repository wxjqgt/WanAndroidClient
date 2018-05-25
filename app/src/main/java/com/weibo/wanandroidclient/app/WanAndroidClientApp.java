package com.weibo.wanandroidclient.app;

import android.app.Application;
import android.content.Context;

public class WanAndroidClientApp extends Application {
    public static Context CONTEXT;
    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = getApplicationContext();
    }
}
