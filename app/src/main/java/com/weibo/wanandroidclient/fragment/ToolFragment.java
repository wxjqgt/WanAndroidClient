package com.weibo.wanandroidclient.fragment;

import com.weibo.wanandroidclient.R;

/**
 * @author weibo
 */
public class ToolFragment extends BaseFragment {

    public static final String TAG = ToolFragment.class.getSimpleName();

    public ToolFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment HomeFragment.
     */
    public static ToolFragment newInstance() {
        ToolFragment fragment = new ToolFragment();
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tool;
    }
}
