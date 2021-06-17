package com.example.headlinenews.mvp;

public class NetPresenter implements IBasePresenter {

    private IBaseView baseView;

    public NetPresenter() {
    }

    public NetPresenter(IBaseView baseView) {
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
        //网络请求

    }
}
