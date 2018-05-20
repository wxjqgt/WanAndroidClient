package com.weibo.wanandroidclient.entity.home;

import com.google.gson.annotations.SerializedName;

public class Data {
    /**
     * curPage	1
     * datas	[…]
     * offset	0
     * over	false
     * pageCount	65
     * size	20
     * total	1291
     */
    public int curPage;
    @SerializedName("datas")
    public Datas_item[] datas_items;
    public int offset;
    public boolean  over;
    public int pageCount;
    public int size;
    public int total;
}
