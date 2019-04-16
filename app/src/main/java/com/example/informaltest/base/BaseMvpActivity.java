package com.example.informaltest.base;
import android.os.Bundle;

import com.example.informaltest.MyApplication;
import com.example.informaltest.component.ActivityComponent;
import com.example.informaltest.component.DaggerActivityComponent;
import com.example.informaltest.module.ActivityModule;

import javax.inject.Inject;


/**
 * Description: MVP Activity基类
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView{

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    /**
     * Dagger 注入
     */
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
