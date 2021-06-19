package com.example.headlinenews.fragment.home.history;

import android.view.MotionEvent;

import com.example.headlinenews.R;
import com.example.headlinenews.base.BaseFragment;
import com.example.headlinenews.fragment.home.history.view.CustomTranslateLayout;
import com.example.headlinenews.mainactivity.MainActivity;


public class HistoryFragment extends BaseFragment {

    private float rawY;
    private CustomTranslateLayout histroyCustom;

    @Override
    protected void initData() {
    }



    @Override
    protected void initView() {

        histroyCustom = (CustomTranslateLayout) findViewById(R.id.histroyCustom);
    }


    @Override
    protected int bindLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}