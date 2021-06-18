package com.example.headlinenews.fragment.homefragment;

import androidx.viewpager.widget.ViewPager;

import com.example.headlinenews.R;
import com.example.headlinenews.base.BaseFragment;
import com.example.headlinenews.fragment.home.history.HistoryFragment;
import com.example.headlinenews.fragment.home.recommend.RecommendFragment;
import com.example.headlinenews.mainactivity.adapter.MainPageAdapter;
import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends BaseFragment {


    private TabLayout homeTab;
    private ViewPager homeViewpage;
    private MainPageAdapter pageAdapter;

    @Override
    protected void initData() {
        pageAdapter.addTitle("推荐");
        pageAdapter.addTitle("历史");
        pageAdapter.addFragment(new RecommendFragment());
        pageAdapter.addFragment(new HistoryFragment());
        homeViewpage.setAdapter(pageAdapter);
        homeTab.setupWithViewPager(homeViewpage);
    }

    @Override
    protected void initView() {

        homeTab = (TabLayout) findViewById(R.id.homeTab);
        homeViewpage = (ViewPager) findViewById(R.id.homeViewpage);
        pageAdapter = new MainPageAdapter(getActivity().getSupportFragmentManager());
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_home;
    }
}