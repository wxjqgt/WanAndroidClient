package com.weibo.wanandroidclient.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.weibo.wanandroidclient.R;
import com.weibo.wanandroidclient.data_service.Home_service;
import com.weibo.wanandroidclient.entity.home.Datas_item;
import com.weibo.wanandroidclient.entity.home.Home;
import com.weibo.wanandroidclient.fragment.HomeFragment;
import com.weibo.wanandroidclient.fragment.NavigationFragment;
import com.weibo.wanandroidclient.fragment.OpenapisFragment;
import com.weibo.wanandroidclient.fragment.ProjectFragment;
import com.weibo.wanandroidclient.fragment.SystemFragment;
import com.weibo.wanandroidclient.fragment.ToolFragment;
import com.weibo.wanandroidclient.util.Constant;
import com.weibo.wanandroidclient.util.LogUtil;
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
    private Fragment lastFragment;

    @Override
    protected void findView() {
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.main_toolbar);
    }

    @Override
    protected void init() {
        int itemCount = 5;
        for (int i = 0; i <= itemCount; i++) {
            navigationView.getMenu().getItem(i)
                    .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            String title = menuItem.getTitle().toString();
                            selectTitle(title);
                            menuItem.setChecked(true);
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
        navigationView.getMenu().getItem(0).setChecked(true);
        lastFragment = HomeFragment.newInstance();
        fm.beginTransaction().add(R.id.fragment, lastFragment, HomeFragment.TAG).commit();
    }

    /**
     * 选择指定标题对应的fragment进行显示
     */
    private void selectTitle(String title) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.hide(lastFragment);
        Fragment fragment = null;
        String tag = null;
        switch (title) {
            case Constant.MENU_ITEM.HOME:
                fragment = fm.findFragmentByTag(HomeFragment.TAG);
                ft.show(fragment);
                break;
            case Constant.MENU_ITEM.SYSTEM:
                tag = SystemFragment.TAG;
                fragment = fm.findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = SystemFragment.newInstance();
                    ft.add(R.id.fragment, fragment, tag);
                } else {
                    ft.show(fragment);
                }
                break;
            case Constant.MENU_ITEM.NAVIGATION:
                tag = NavigationFragment.TAG;
                fragment = fm.findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = NavigationFragment.newInstance();
                    ft.add(R.id.fragment, fragment, tag);
                } else {
                    ft.show(fragment);
                }
                break;
            case Constant.MENU_ITEM.PROJECT:
                tag = ProjectFragment.TAG;
                fragment = fm.findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = ProjectFragment.newInstance();
                    ft.add(R.id.fragment, fragment, tag);
                } else {
                    ft.show(fragment);
                }
                break;
            case Constant.MENU_ITEM.OPENAPIS:
                tag = OpenapisFragment.TAG;
                fragment = fm.findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = OpenapisFragment.newInstance();
                    ft.add(R.id.fragment, fragment, tag);
                } else {
                    ft.show(fragment);
                }
                break;
            case Constant.MENU_ITEM.TOOL:
                tag = ToolFragment.TAG;
                fragment = fm.findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = ToolFragment.newInstance();
                    ft.add(R.id.fragment, fragment, tag);
                } else {
                    ft.show(fragment);
                }
                break;
            default:
                break;
        }
        lastFragment = fragment;
        ft.commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
