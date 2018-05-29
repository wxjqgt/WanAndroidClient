package com.weibo.wanandroidclient.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public abstract class BaseActivity extends RxAppCompatActivity {
    protected FragmentManager fm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        fm = getSupportFragmentManager();
        findView();
        init();
    }
    protected void init(){}
    protected void findView(){}
    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fm = null;
    }
}
