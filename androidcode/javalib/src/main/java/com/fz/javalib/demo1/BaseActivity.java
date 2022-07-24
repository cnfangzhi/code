package com.fz.javalib.demo1;


/**
 * Created by fz on 2017/9/4.
 */

public class BaseActivity{

    // 上限
    public void startActivity(Class<? extends BaseActivity> clazz) {
    }

    // 下限 包括 MainActivity 和它的父类
    public void startActivity1(Class<? super BaseActivity> clazz) {
    }
}
