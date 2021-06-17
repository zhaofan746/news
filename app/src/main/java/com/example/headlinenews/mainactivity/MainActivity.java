package com.example.headlinenews.mainactivity;



import androidx.viewpager.widget.ViewPager;


import com.example.headlinenews.R;
import com.example.headlinenews.base.BaseActivity;
import com.example.headlinenews.fragment.homefragment.HomeFragment;
import com.example.headlinenews.fragment.minefragment.MineFragment;
import com.example.headlinenews.fragment.topline.ToplineFragment;
import com.example.headlinenews.fragment.videofragment.VideoFragment;
import com.example.headlinenews.mainactivity.adapter.MainPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActivity {


    private ViewPager mainViewpage;
    private TabLayout mainTab;
    private MainPageAdapter pagerAdapter;

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
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }
}