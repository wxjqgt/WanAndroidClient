package com.weibo.wanandroidclient.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weibo.wanandroidclient.R;
import com.weibo.wanandroidclient.entity.home.banner.Banner;
import com.weibo.wanandroidclient.util.GlideUtil;
import com.weibo.wanandroidclient.widget.yviewpager.ADViewpager;

import java.util.List;

public class BannerAdapter extends ADViewpager.CommonViewPagerAdapter<Banner.Data> {

    private  Context context;

    public BannerAdapter(List<Banner.Data> datas, Context context) {
        super(datas);
        this.context = context;
    }

    @Override
    public View convert(Banner.Data data, int position) {
        View view = View.inflate(context, R.layout.banner_item,null);
        ImageView imageView = view.findViewById(R.id.iv_banner);
        TextView textView = view.findViewById(R.id.tv_banner);
        GlideUtil.load(imageView,data.getImagePath(),imageView);
        textView.setText(data.getTitle());
        return view;
    }

}
