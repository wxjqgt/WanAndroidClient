package com.weibo.wanandroidclient.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.weibo.wanandroidclient.entity.home.banner.Banner;
import com.weibo.wanandroidclient.util.GlideUtil;
import com.weibo.wanandroidclient.widget.ADViewpager;

import java.util.List;

public class BannerAdapter extends ADViewpager.CommonViewPagerAdapter<Banner.Data> {

    private  Context context;

    public BannerAdapter(List<Banner.Data> datas, Context context) {
        super(datas);
        this.context = context;
    }

    @Override
    public View convert(Banner.Data data, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        GlideUtil.load(imageView,data.getImagePath(),imageView);
        return imageView;
    }

}
