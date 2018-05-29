package com.weibo.wanandroidclient.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.weibo.wanandroidclient.R;
import com.weibo.wanandroidclient.fragment.HomeFragment;
import com.weibo.wanandroidclient.fragment.NavigationFragment;
import com.weibo.wanandroidclient.fragment.OpenapisFragment;
import com.weibo.wanandroidclient.fragment.ProjectFragment;
import com.weibo.wanandroidclient.fragment.SystemFragment;
import com.weibo.wanandroidclient.fragment.ToolFragment;

/**
 * @author weibo
 * 主Activity
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Fragment lastFragment;

    @Override
    protected void findView() {
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.home);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void init() {
        navigationView.getMenu().getItem(0).setChecked(true);
        lastFragment = HomeFragment.newInstance();
        fm.beginTransaction().add(R.id.fragment, lastFragment, HomeFragment.TAG).commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        selectFragment(menuItem.getItemId());
        toolbar.setTitle(menuItem.getTitle());
        drawerLayout.closeDrawer(Gravity.START);
        return true;
    }
    /**
     * 选择指定标题对应的fragment进行显示
     */
    private void selectFragment(int itemId) {
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;
        ft.hide(lastFragment);
        switch (itemId) {
            case R.id.home:
                fragment = fm.findFragmentByTag(HomeFragment.TAG);
                ft.show(fragment);
                break;
            case R.id.system:
                String tag = SystemFragment.TAG;
                fragment = fm.findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = SystemFragment.newInstance();
                    ft.add(R.id.fragment, fragment, tag);
                } else {
                    ft.show(fragment);
                }
                break;
            case R.id.navigation:
                tag = NavigationFragment.TAG;
                fragment = fm.findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = NavigationFragment.newInstance();
                    ft.add(R.id.fragment, fragment, tag);
                } else {
                    ft.show(fragment);
                }
                break;
            case R.id.project:
                tag = ProjectFragment.TAG;
                fragment = fm.findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = ProjectFragment.newInstance();
                    ft.add(R.id.fragment, fragment, tag);
                } else {
                    ft.show(fragment);
                }
                break;
            case R.id.openapis:
                tag = OpenapisFragment.TAG;
                fragment = fm.findFragmentByTag(tag);
                if (fragment == null) {
                    fragment = OpenapisFragment.newInstance();
                    ft.add(R.id.fragment, fragment, tag);
                } else {
                    ft.show(fragment);
                }
                break;
            case R.id.tool:
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

}
