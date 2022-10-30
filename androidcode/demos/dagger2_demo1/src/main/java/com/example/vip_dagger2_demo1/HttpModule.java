package com.example.vip_dagger2_demo1;

import com.example.vip_dagger2_demo1.object.HttpObject;
import com.example.vip_dagger2_demo1.scope.AppScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 用来提供对象
 */
@AppScope
@Module
public class HttpModule {

    @AppScope
    @Provides
    public HttpObject providerHttpObject(){
        //........
        return new HttpObject();
    }

//    @Provides
//    public Object abd(){
//        return new Object();
//    }

}
