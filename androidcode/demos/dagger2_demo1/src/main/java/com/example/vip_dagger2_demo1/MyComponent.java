package com.example.vip_dagger2_demo1;

import com.example.vip_dagger2_demo1.di.PresenterComponent;
import com.example.vip_dagger2_demo1.scope.AppScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 存放module的组件
 */
@AppScope
@Component(modules = {HttpModule.class,DatabaseModule.class}
            ,dependencies = {PresenterComponent.class})
public interface MyComponent {
    //注入的位置就写在参数上        不能用多态
    void injectMainActivity(MainActivity mainActivity);

    void injectSecActivity(SecActivity secActivity);
}
