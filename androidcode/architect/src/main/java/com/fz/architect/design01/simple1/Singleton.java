package com.fz.architect.design01.simple1;

/**
 * 单例 - 饿汉式
 * Created by fz on 2017/9/17.
 */
public class Singleton {
    // 随着类的加载就已经 new 了对象
    private static Singleton mInstance = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return mInstance;
    }
}
