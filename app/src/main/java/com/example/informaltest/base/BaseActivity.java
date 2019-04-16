package com.example.informaltest.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.informaltest.MyApplication;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description: Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity{

    protected Activity mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(getLayout());
        getIntentData();
        mContext = this;
        mUnBinder = ButterKnife.bind(this);

        initView();
    }

    protected void init() {
        MyApplication.getInstance().registerActivity(this);
    }

    protected abstract int getLayout();

    protected abstract void initView();

    protected void getIntentData() {}

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnBinder != null)
            mUnBinder.unbind();
        MyApplication.getInstance().unregisterActivity(this);
    }
}
