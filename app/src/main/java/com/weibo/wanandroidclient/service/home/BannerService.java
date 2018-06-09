package com.weibo.wanandroidclient.service.home;

import com.weibo.wanandroidclient.entity.home.banner.Banner;
import com.weibo.wanandroidclient.util.Constant;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BannerService {
    @GET(Constant.HOME_BANNER)
    Observable<Banner> getBanner();
}
