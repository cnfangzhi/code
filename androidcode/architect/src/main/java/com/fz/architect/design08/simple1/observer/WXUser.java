package com.fz.architect.design08.simple1.observer;

/**
 * Created by fz on 2017/10/14.
 * 微信公众号 - 具体订阅用户（Darren，高岩）
 */

public class WXUser implements IWXUser {

    private String name;

    public WXUser(String name) {
        this.name = name;
    }

    @Override
    public void push(String article) {
        System.out.println(name + " 收到了一篇文章：" + article);
    }
}
