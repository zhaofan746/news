package com.example.headlinenews.mvp;

import android.os.AsyncTask;

public class LocatPresenter implements IBasePresenter {
    private IBaseView baseView;

    public LocatPresenter() {
    }

    public LocatPresenter(IBaseView baseView) {
        attachView(baseView);
    }

    @Override
    public void attachView(IBaseView baseView) {
        this.baseView = baseView;

    }

    @Override
    public void detachedView(IBaseView baseView) {
        this.baseView = null;
    }

    @Override
    public void getData() {
        //获取数据、从本地


    }
}
