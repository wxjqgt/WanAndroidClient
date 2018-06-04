package com.weibo.wanandroidclient.fragment;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.weibo.wanandroidclient.R;
import com.weibo.wanandroidclient.adapter.recyclerview.CommonAdapter;
import com.weibo.wanandroidclient.adapter.recyclerview.ViewHolder;
import com.weibo.wanandroidclient.entity.home.Datas_item;
import com.weibo.wanandroidclient.entity.home.Home;
import com.weibo.wanandroidclient.service.home.Article;
import com.weibo.wanandroidclient.util.RetrofitUtil;

import java.util.Arrays;

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
                .map(new Function<Home, Datas_item[]>() {
                    @Override
                    public Datas_item[] apply(Home home) {
                        return home.data.datas_items;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Datas_item[]>() {
                    @Override
                    public void accept(Datas_item[] datas_items) throws Exception {
                        CommonAdapter<Datas_item> adapter = new CommonAdapter<Datas_item>(context,R.layout.article_item, Arrays.asList(datas_items)) {
                            @Override
                            public void convert(ViewHolder holder, Datas_item datas_item, int position) {
                                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#1296db"));

                                SpannableString authorString = new SpannableString("作者：" + datas_item.author);
                                authorString.setSpan(foregroundColorSpan,3,authorString.length(),Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                                holder.setText(R.id.tv_author,authorString);

                                SpannableString chapterNameString = new SpannableString("分类：" + datas_item.chapterName);
                                chapterNameString.setSpan(foregroundColorSpan,3,chapterNameString.length(),Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                                holder.setText(R.id.tv_chapterName,chapterNameString);

                                holder.setText(R.id.tv_title,datas_item.title);
                                holder.setText(R.id.tv_niceDate,datas_item.niceDate);
                            }
                        };
                        recyclerView_article.setAdapter(adapter);

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
