package com.example.headlinenews.mvp;

public interface IBasePresenter {
    void attachView(IBaseView baseView);
    void detachedView(IBaseView baseView);
    void getData();
}
