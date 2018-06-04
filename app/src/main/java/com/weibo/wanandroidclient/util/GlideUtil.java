package com.weibo.wanandroidclient.util;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public final class GlideUtil {
    public static void into(View view, int resId, ImageView imageView){
        Glide.with(view).load(resId).into(imageView);
    }
}
