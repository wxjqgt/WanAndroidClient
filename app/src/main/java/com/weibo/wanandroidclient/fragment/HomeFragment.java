package com.weibo.wanandroidclient.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.weibo.wanandroidclient.R;
import com.weibo.wanandroidclient.service.home.Article;
import com.weibo.wanandroidclient.entity.home.Datas_item;
import com.weibo.wanandroidclient.entity.home.Home;
import com.weibo.wanandroidclient.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author weibo
 */
public class HomeFragment extends BaseFragment {

    public static final String TAG = HomeFragment.class.getSimpleName();

    private RecyclerView recyclerView_article;

    @Override
    protected void initView() {
        recyclerView_article = view.findViewById(R.id.recycleView_article);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView_article.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void loadData() {
        getBannerData();
        getArticleData(0);
    }

    private void getBannerData() {

    }

    private void getArticleData(int pageCount) {
        //获取首页文章数据
        RetrofitUtil.build().create(Article.class)
                .getArticle(pageCount)
                .compose(this.<Home>bindToLifecycle())
                .flatMap(new Function<Home, ObservableSource<Datas_item>>() {
                    @Override
                    public ObservableSource<Datas_item> apply(Home home) throws Exception {
                        return Observable.fromArray(home.data.datas_items);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Datas_item>() {
                    @Override
                    public void accept(Datas_item datas_item) throws Exception {

                    }
                });
    }

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
