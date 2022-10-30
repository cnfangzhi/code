package com.example.vip_dagger2_demo2.di;

import com.example.vip_dagger2_demo2.MainActivity;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent (modules = {TestSubModule.class})
public interface TestSubComponent {
    void injectMainActivity(MainActivity mainActivity);
}
