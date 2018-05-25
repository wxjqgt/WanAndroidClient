package com.weibo.wanandroidclient.data_service;

import com.weibo.wanandroidclient.entity.home.Home;
import com.weibo.wanandroidclient.util.Constant;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Home_service {
    @GET(Constant.URL.HOME)
    Observable<Home> getHomeData();
}
