package com.example.vip_dagger2_demo1;

import android.app.Application;

import com.example.vip_dagger2_demo1.di.DaggerPresenterComponent;

public class MyApplication extends Application {
    private MyComponent myComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myComponent=DaggerMyComponent.builder()
                .httpModule(new HttpModule())
                .databaseModule(new DatabaseModule())
                .presenterComponent(DaggerPresenterComponent.create())
                .build();
    }

    public MyComponent getMyComponent() {
        return myComponent;
    }
}
