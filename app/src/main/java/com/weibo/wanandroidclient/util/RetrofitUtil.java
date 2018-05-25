package com.weibo.wanandroidclient.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitUtil {
    private static final class RetrofitBuildHelper{
        private static final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.URL.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit build(){
        return RetrofitBuildHelper.retrofit;
    }
}
