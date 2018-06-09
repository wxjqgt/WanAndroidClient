package com.weibo.wanandroidclient.service.home;

import com.weibo.wanandroidclient.entity.home.article.HomeArticle;
import com.weibo.wanandroidclient.util.Constant;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author weibo
 * 首页文章数据
 */
public interface ArticleService {
    @GET(Constant.HOME + "{pageCount}/json")
    Observable<HomeArticle> getArticle(@Path("pageCount") int pageCount);
}
