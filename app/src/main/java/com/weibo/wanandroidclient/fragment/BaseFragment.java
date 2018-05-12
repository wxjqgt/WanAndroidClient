package com.weibo.wanandroidclient.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;

import com.trello.rxlifecycle2.components.support.RxFragment;

public abstract class BaseFragment extends RxFragment {
    protected Context context;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }
    @LayoutRes
    protected abstract int getLayoutId();
}
