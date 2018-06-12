package com.weibo.wanandroidclient.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.weibo.wanandroidclient.R;
import com.weibo.wanandroidclient.adapter.ArticleAdapter;
import com.weibo.wanandroidclient.adapter.BannerAdapter;
import com.weibo.wanandroidclient.adapter.recyclerview.CommonAdapter;
import com.weibo.wanandroidclient.adapter.recyclerview.HeaderAndFooterWrapper;
import com.weibo.wanandroidclient.entity.home.article.DatasItem;
import com.weibo.wanandroidclient.entity.home.article.HomeArticle;
import com.weibo.wanandroidclient.entity.home.banner.Banner;
import com.weibo.wanandroidclient.service.home.ArticleService;
import com.weibo.wanandroidclient.service.home.BannerService;
import com.weibo.wanandroidclient.util.RetrofitUtil;
import com.weibo.wanandroidclient.widget.ADViewpager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author weibo
 */
public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    public static final String TAG = HomeFragment.class.getSimpleName();
    private int lastVisibleItem, pageCount = 0;

    private RecyclerView recyclerView_article;
    private SwipeRefreshLayout refreshLayout;
    private View headerView;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
    private HeaderAndFooterWrapper<DatasItem> adapter;
    private BannerAdapter bannerAdapter;

    @Override
    protected void initView() {
        recyclerView_article = view.findViewById(R.id.recycleView_article);
        recyclerView_article.setLayoutManager(linearLayoutManager);
        CommonAdapter articleAdapter = new ArticleAdapter(context, R.layout.article_item, new ArrayList<DatasItem>());
        adapter = new HeaderAndFooterWrapper<>(articleAdapter);

        headerView = View.inflate(context, R.layout.home_banner, null);
        View footerView = View.inflate(context, R.layout.home_loadmore, null);
        adapter.addHeaderView(headerView);
        adapter.addFootView(footerView);

        recyclerView_article.setAdapter(adapter);

        refreshLayout = view.findViewById(R.id.swipeRefresh_home);
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected void loadData() {
        getBannerData();
        getArticleData(pageCount);
    }

    private void getBannerData() {
        RetrofitUtil.build()
                .create(BannerService.class)
                .getBanner()
                .compose(this.<Banner>bindToLifecycle())
                .map(new Function<Banner, List<Banner.Data>>() {
                    @Override
                    public List<Banner.Data> apply(Banner banner) {
                        return banner.getData();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Banner.Data>>() {
                    @Override
                    public void accept(List<Banner.Data> datas) throws Exception {
                        if (bannerAdapter == null) {
                            bannerAdapter = new BannerAdapter(datas, context);
                            final ADViewpager vp_banner = headerView.findViewById(R.id.vp_banner);
                            vp_banner.setIcon(R.mipmap.selected, R.mipmap.reverse);
                            vp_banner.setAdapter(bannerAdapter);
                            vp_banner.startCycle();
                            bannerAdapter.registTitleSettingListener(new ADViewpager.TitleSetting<Banner.Data>() {
                                @Override
                                public void setTitle(Banner.Data data) {
                                    vp_banner.setTitle(data.getTitle());
                                }
                            });
                        } else {
                            bannerAdapter.setDatas(datas);
                        }
                    }
                });
    }

    private void getArticleData(final int pageCount) {
        //获取首页文章数据
        RetrofitUtil.build().create(ArticleService.class)
                .getArticle(pageCount)
                .compose(this.<HomeArticle>bindToLifecycle())
                .map(new Function<HomeArticle, DatasItem[]>() {
                    @Override
                    public DatasItem[] apply(HomeArticle home_article) {
                        return home_article.data.datas_items;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DatasItem[]>() {
                    @Override
                    public void accept(DatasItem[] datas_items) throws Exception {
                        adapter.addDatas(Arrays.asList(datas_items));
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    protected void listener() {
        recyclerView_article.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    pageCount++;
                    getArticleData(pageCount);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    public void onRefresh() {
        pageCount = 0;
        adapter.clear();
        loadData();
        refreshLayout.setRefreshing(false);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        bannerAdapter.unRegistTitleSettingListener();
    }
}