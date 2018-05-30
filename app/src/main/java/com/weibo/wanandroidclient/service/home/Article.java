package com.weibo.wanandroidclient.service.home;

import com.weibo.wanandroidclient.entity.home.Home;
import com.weibo.wanandroidclient.util.Constant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author weibo
 * 首页文章数据
 */
public interface Article {
    @GET(Constant.URL.HOME + "{pageCount}/json")
    Observable<Home> getArticle(@Path("pageCount") int pageCount);
}
