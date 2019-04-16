package com.example.informaltest.base;

public interface BaseView {

    void showError();
    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 加载完成
     */
    void loadComplete();

    /**
     * 数据为空
     */
    void showEmpty();
}
