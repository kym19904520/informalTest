package com.example.informaltest.component;

import android.app.Activity;

import com.example.informaltest.module.ActivityModule;
import com.example.informaltest.scope.ActivityScope;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity getActivity();
}
