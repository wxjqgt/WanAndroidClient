package com.weibo.wanandroidclient.fragment;

import com.weibo.wanandroidclient.R;

/**
 * @author weibo
 */
public class SystemFragment extends BaseFragment {

    public static final String TAG = SystemFragment.class.getSimpleName();

    public SystemFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment HomeFragment.
     */
    public static SystemFragment newInstance() {
        SystemFragment fragment = new SystemFragment();
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_system;
    }
}
