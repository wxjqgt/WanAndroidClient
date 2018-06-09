package com.weibo.wanandroidclient.util;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public final class GlideUtil {
    public static void load(View view, int resId, ImageView imageView){
        Glide.with(view).load(resId).into(imageView);
    }
    public static void load(View view,String url, ImageView imageView){
        Glide.with(view).load(url).into(imageView);
    }
}
