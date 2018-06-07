package com.weibo.wanandroidclient.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;

import com.weibo.wanandroidclient.BuildConfig;
import com.weibo.wanandroidclient.util.logger.AndroidLogAdapter;
import com.weibo.wanandroidclient.util.logger.Logger;

public class WanAndroidClientApp extends Application {
    public static Context CONTEXT;
    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = getApplicationContext();
        Logger.addLogAdapter(new AndroidLogAdapter(){
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }
}
