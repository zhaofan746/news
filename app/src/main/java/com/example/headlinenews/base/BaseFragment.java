package com.example.headlinenews.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.headlinenews.mvp.IBasePresenter;
import com.example.headlinenews.mvp.IBaseView;
import com.example.headlinenews.mvp.LocatPresenter;
import com.example.headlinenews.mvp.NetPresenter;

public abstract class BaseFragment extends LazyLoadFragment implements IBaseView {
    private View rootView;
    private IBasePresenter basePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(bindLayoutId(), container, false);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        initData();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void prepareLoactOrNet() {
        //请求
        basePresenter = new LocatPresenter(this);
        basePresenter.getData();
        basePresenter.detachedView(this);

    }

    public <T extends View> T findViewById(@IdRes int id) {
        return rootView.findViewById(id);
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int bindLayoutId();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onSuccess() {
        //判断有数据
        basePresenter = new NetPresenter(this);
        basePresenter.getData();
        basePresenter.detachedView(this);

    }

    @Override
    public void onError(String error) {

    }

}
