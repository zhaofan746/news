package com.example.headlinenews.fragment.home.recommend;

import androidx.recyclerview.widget.RecyclerView;

import com.example.headlinenews.R;
import com.example.headlinenews.base.BaseFragment;


public class RecommendFragment extends BaseFragment {


    private RecyclerView comRv;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        comRv = (RecyclerView) findViewById(R.id.comRv);
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_recommend;
    }
}