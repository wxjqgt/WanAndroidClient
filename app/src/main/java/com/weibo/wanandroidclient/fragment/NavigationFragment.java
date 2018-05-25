package com.weibo.wanandroidclient.fragment;

import com.weibo.wanandroidclient.R;

/**
 * @author weibo
 */
public class NavigationFragment extends BaseFragment {

    public static final String TAG = NavigationFragment.class.getSimpleName();

    public NavigationFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment HomeFragment.
     */
    public static NavigationFragment newInstance() {
        NavigationFragment fragment = new NavigationFragment();
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_navigation;
    }
}
