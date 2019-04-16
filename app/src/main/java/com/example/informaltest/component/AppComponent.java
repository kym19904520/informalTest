package com.example.informaltest.component;


import com.example.informaltest.MyApplication;
import com.example.informaltest.module.AppModule;


import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    MyApplication getContext();  // 提供App的Context
}
