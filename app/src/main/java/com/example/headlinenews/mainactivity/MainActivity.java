package com.example.headlinenews.mainactivity;



import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;


import com.example.headlinenews.R;
import com.example.headlinenews.base.BaseActivity;
import com.example.headlinenews.fragment.home.history.view.CustomTranslateLayout;
import com.example.headlinenews.fragment.homefragment.HomeFragment;
import com.example.headlinenews.fragment.minefragment.MineFragment;
import com.example.headlinenews.fragment.topline.ToplineFragment;
import com.example.headlinenews.fragment.videofragment.VideoFragment;
import com.example.headlinenews.mainactivity.adapter.MainPageAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private ViewPager mainViewpage;
    private TabLayout mainTab;
    private MainPageAdapter pagerAdapter;
    private CustomTranslateLayout histroyCustom;
    private float rawY;

    @Override
    protected void initData() {
        pagerAdapter.addFragment(new HomeFragment());
        pagerAdapter.addFragment(new VideoFragment());
        pagerAdapter.addFragment(new ToplineFragment());
        pagerAdapter.addFragment(new MineFragment());
        pagerAdapter.addTitle("首页");
        pagerAdapter.addTitle("视频");
        pagerAdapter.addTitle("头条");
        pagerAdapter.addTitle("我的");

        mainViewpage.setAdapter(pagerAdapter);
        mainTab.setupWithViewPager(mainViewpage);

    }

    @Override
    protected void initView() {

        mainViewpage = (ViewPager) findViewById(R.id.mainViewpage);
        mainTab = (TabLayout) findViewById(R.id.mainTab);
        pagerAdapter = new MainPageAdapter(getSupportFragmentManager());
        histroyCustom = (CustomTranslateLayout) findViewById(R.id.histroyCustom);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            rawY = ev.getRawY();
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            if (ev.getRawY() < rawY) {
                histroyCustom.resetWidth(ev);
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}