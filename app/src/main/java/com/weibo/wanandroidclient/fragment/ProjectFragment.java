package com.weibo.wanandroidclient.fragment;

import com.weibo.wanandroidclient.R;

/**
 * @author weibo
 */
public class ProjectFragment extends BaseFragment {

    public static final String TAG = ProjectFragment.class.getSimpleName();

    public ProjectFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment HomeFragment.
     */
    public static ProjectFragment newInstance() {
        ProjectFragment fragment = new ProjectFragment();
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }
}
