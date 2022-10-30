package com.example.vip_dagger2_demo1.di;




import com.example.vip_dagger2_demo1.scope.UserScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@UserScope
@Module
public class PresenterModule {


    @UserScope
    @Provides
    public Presenter providePresenter(){
        return new Presenter();
    }
}
