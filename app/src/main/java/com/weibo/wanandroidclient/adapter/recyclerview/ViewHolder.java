package com.weibo.wanandroidclient.adapter.recyclerview;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weibo.wanandroidclient.util.GlideUtil;

/**
 * Created by Administrator on 2016/7/9.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private View itemView;
    private Context context;

    private SparseArrayCompat<View> views = new SparseArrayCompat<>();

    public ViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        this.itemView = itemView;
    }

    public static ViewHolder createViewHolder(Context context, View view) {
        return new ViewHolder(view, context);
    }

    public <T extends View> T getView(int id) {
        View view = views.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            views.put(id, view);
        }
        return (T) view;
    }

    public void setText(int id, CharSequence text) {
        ((TextView) getView(id)).setText(text);
    }

    public void setImageView(int id, int resId) {
        ImageView imageView = getView(id);
        GlideUtil.into(itemView, resId, imageView);
    }

}
