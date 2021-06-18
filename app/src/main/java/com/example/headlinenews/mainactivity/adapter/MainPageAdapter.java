package com.example.headlinenews.mainactivity.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainPageAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;
    private List<String> titles;
    public MainPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
    }

    public void addFragment(Fragment fragment){
        fragments.add(fragment);
    }

    public void addTitle(String title){
        titles.add(title);
    }
    public int getTitle(){
        return titles.size();
    }

    public void removeTitleAndFragment(String title){
        for (int i = 0; i < titles.size(); i++) {
            if(titles.get(i).equals(title)){
                titles.remove(i);
                fragments.remove(i);
            }
        }
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
