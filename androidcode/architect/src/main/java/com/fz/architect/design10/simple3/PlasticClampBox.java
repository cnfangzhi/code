package com.fz.architect.design10.simple3;

/**
 * Created by fz on 2017/10/21.
 * 具体的出货的物品 - 塑料夹子
 */

public class PlasticClampBox extends IBox {
    private int number;
    private String name;
    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
