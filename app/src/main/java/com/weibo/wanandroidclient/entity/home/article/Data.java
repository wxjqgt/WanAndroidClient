package com.weibo.wanandroidclient.entity.home.article;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

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
    public DatasItem[] datas_items;
    public int offset;
    public boolean  over;
    public int pageCount;
    public int size;
    public int total;

    public Data(int curPage, DatasItem[] datas_items, int offset, boolean over, int pageCount, int size, int total) {
        this.curPage = curPage;
        this.datas_items = datas_items;
        this.offset = offset;
        this.over = over;
        this.pageCount = pageCount;
        this.size = size;
        this.total = total;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public DatasItem[] getDatas_items() {
        return datas_items;
    }

    public void setDatas_items(DatasItem[] datas_items) {
        this.datas_items = datas_items;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Data{" +
                "curPage=" + curPage +
                ", datas_items=" + Arrays.toString(datas_items) +
                ", offset=" + offset +
                ", over=" + over +
                ", pageCount=" + pageCount +
                ", size=" + size +
                ", total=" + total +
                '}';
    }
}
