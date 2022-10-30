package com.example.vip_dagger2_demo1.di;



import com.example.vip_dagger2_demo1.MainActivity;
import com.example.vip_dagger2_demo1.scope.UserScope;

import javax.inject.Singleton;

import dagger.Component;

@UserScope
@Component(modules = {PresenterModule.class})
public interface PresenterComponent {
    //使用依赖关系，就不再使用这种语法
//    void inject(MainActivity activity);
    Presenter providerPresenter();

}
