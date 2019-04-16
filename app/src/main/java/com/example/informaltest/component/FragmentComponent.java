package com.example.informaltest.component;

import android.app.Activity;

import com.example.informaltest.module.FragmentModule;
import com.example.informaltest.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();
}
