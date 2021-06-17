package com.example.headlinenews.mvp;

public interface IBaseView {
    void showLoading();
    void hideLoading();
    void onSuccess();
    void onError(String error);
}
