package com.fz.architect.design10.simple2;

/**
 * Created by fz on 2017/10/21.
 * 出货的箱子接口
 */

public interface IBox {
    void setNumber(int number);// 设置箱子的数量

    int getNumber();// 有多少货

    // 新增一个方法 - 拷贝
    IBox copy();
}
