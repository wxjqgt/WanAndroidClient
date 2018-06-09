package com.weibo.wanandroidclient.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.weibo.wanandroidclient.R;
import com.weibo.wanandroidclient.adapter.recyclerview.CommonAdapter;
import com.weibo.wanandroidclient.adapter.recyclerview.ViewHolder;
import com.weibo.wanandroidclient.entity.home.article.DatasItem;

import java.util.List;

public class ArticleAdapter extends  CommonAdapter<DatasItem>{

    public ArticleAdapter(Context context, int layoutId, List<DatasItem> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, DatasItem datas_item, int position) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#1296db"));

        SpannableString authorString = new SpannableString("作者：" + datas_item.getAuthor());
        authorString.setSpan(foregroundColorSpan, 3, authorString.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        holder.setText(R.id.tv_author, authorString);

        SpannableString chapterNameString = new SpannableString("分类：" + datas_item.getChapterName());
        chapterNameString.setSpan(foregroundColorSpan, 3, chapterNameString.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        holder.setText(R.id.tv_chapterName, chapterNameString);

        holder.setText(R.id.tv_title, datas_item.getTitle());
        holder.setText(R.id.tv_niceDate, datas_item.getNiceDate());
    }
}

