package com.weibo.wanandroidclient.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.weibo.wanandroidclient.R;
import com.weibo.wanandroidclient.data_service.Home_service;
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
 * 主Activity
 */
public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void findView() {
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.main_toolbar);
    }

    @Override
    protected void init() {
        for (int i = 0; i < 6; i++) {
            navigationView.getMenu().getItem(i)
                    .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            String title = menuItem.getTitle().toString();
                            selectTitle(title);
                            drawerLayout.closeDrawer(Gravity.LEFT);
                            return false;
                        }
                    });
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    /**
     * 选择指定标题对应的fragment进行显示
     */
    private void selectTitle(String title) {
        switch (title) {
            case "首页":
                handleHomeData();
            default:
                break;
        }
    }

    private void handleHomeData() {
        RetrofitUtil.build().create(Home_service.class)
                .get()
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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
