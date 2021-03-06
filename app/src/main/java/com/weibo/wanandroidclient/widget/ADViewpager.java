package com.weibo.wanandroidclient.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weibo.wanandroidclient.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/8.
 */
public class ADViewpager extends FrameLayout implements ViewPager.OnPageChangeListener {

    private static final int OK = 0x1;

    private Context context;
    private boolean recycle = false;

    private int frontRes, reversRes, seconds = 5, count;
    private LinearLayout linearLayout;
    private ViewPager viewPager;
    private ImageView lastImageView;
    private TextView textView_title;

    public void setAdapter(PagerAdapter pagerAdapter) {
        viewPager.setAdapter(pagerAdapter);
        count = pagerAdapter.getCount();
        build();
    }

    public void setIconGravity(int gravity) {
        linearLayout.setGravity(gravity);
    }

    public void setCycleTime(int seconds) {
        if (seconds > 0) {
            this.seconds = seconds;
        }
    }

    public void startCycle() {
        recycle = true;
    }

    public void setIcon(int frontRes, int reversRes) {
        this.frontRes = frontRes;
        this.reversRes = reversRes;
    }

    private void init(Context context) {
        this.context = context;
        inflate(context, R.layout.viewpager, this);
        viewPager = findViewById(R.id.viewpager);
        linearLayout = findViewById(R.id.linear_icon);
        textView_title = findViewById(R.id.title);
    }

    private void build() {
        viewPager.addOnPageChangeListener(this);
        int icons = count - 2;
        for (int i = 0; i < icons; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(reversRes);
            linearLayout.addView(imageView);
        }
        viewPager.setCurrentItem(1);
    }

    public void stopCycle() {
        recycle = false;
    }

    public ADViewpager(Context context) {
        super(context);
        init(context);
    }

    public ADViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ADViewpager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(final int position) {
        int p = position;
        if (position == count - 1) {
            p = 1;
            viewPager.postDelayed(new Runnable() {
                @Override
                public void run() {
                    viewPager.setCurrentItem(1, false);
                }
            }, 1000);
        } else if (position == 0) {
            p = count - 2;
            viewPager.postDelayed(new Runnable() {
                @Override
                public void run() {
                    viewPager.setCurrentItem(count - 2, false);
                }
            }, 1000);
        } else {
            viewPager.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (recycle) {
                        viewPager.setCurrentItem(position + 1);
                    }
                }
            }, seconds * 1000);
        }
        if (lastImageView != null) {
            lastImageView.setImageResource(reversRes);
        }
        ImageView imageView = (ImageView) linearLayout.getChildAt(p - 1);
        imageView.setImageResource(frontRes);
        lastImageView = imageView;
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    public void setTitle(String title){
        textView_title.setText(title);
    }

    public interface TitleSetting<T> {
        void setTitle(T t);
    }

    public abstract static class CommonViewPagerAdapter<T> extends PagerAdapter {

        private List<T> datas;
        public TitleSetting<T> titleSetting;

        public CommonViewPagerAdapter(List<T> datas) {
            this.datas = new ArrayList<>();
            int size = datas.size();
            this.datas.add(datas.get(size - 1));
            this.datas.addAll(datas);
            this.datas.add(datas.get(0));
        }

        public void setDatas(List<T> datas) {
            this.datas.clear();
            int size = datas.size();
            this.datas.add(datas.get(size - 1));
            this.datas.addAll(datas);
            this.datas.add(datas.get(0));
            this.notifyDataSetChanged();
        }

        public void registTitleSettingListener(TitleSetting<T> titleSetting) {
            this.titleSetting = titleSetting;
        }

        public void unRegistTitleSettingListener() {
            titleSetting = null;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = convert(datas.get(position), position);
            if(titleSetting != null) {
                if (position == 0) {
                    titleSetting.setTitle(datas.get(datas.size() - 1));
                } else {
                    titleSetting.setTitle(datas.get(position - 1));
                }
            }
            container.addView(view);
            return view;
        }

        public abstract View convert(T t, int position);

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
