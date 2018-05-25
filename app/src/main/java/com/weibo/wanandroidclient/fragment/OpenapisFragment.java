package com.weibo.wanandroidclient.fragment;

import com.weibo.wanandroidclient.R;

/**
 * @author weibo
 */
public class OpenapisFragment extends BaseFragment {

    public static final String TAG = OpenapisFragment.class.getSimpleName();

    public OpenapisFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment HomeFragment.
     */
    public static OpenapisFragment newInstance() {
        OpenapisFragment fragment = new OpenapisFragment();
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_openapis;
    }
}
