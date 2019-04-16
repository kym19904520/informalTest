package com.example.informaltest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.informaltest.MyApplication;
import com.example.informaltest.component.DaggerFragmentComponent;
import com.example.informaltest.component.FragmentComponent;
import com.example.informaltest.module.FragmentModule;

import javax.inject.Inject;

/**
 *  MVP Fragment基类
 */
public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null) mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) mPresenter.detachView();
        mPresenter = null;
        super.onDestroy();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected abstract void initInject();

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void loadComplete() {

    }

    @Override
    public void showError() {

    }
}
