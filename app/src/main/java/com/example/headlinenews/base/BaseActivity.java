package com.example.headlinenews.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    @LayoutRes
    protected abstract int bindLayoutId();
}
