package com.fz.architect.design04.simple1;

import android.util.Log;

/**
 * Created by fz on 2017/9/30.
 */

public class StudentEat implements Eat{
    @Override
    public void eat() {
        Log.e("TAG","点个菜");
        Log.e("TAG","吃饭吃菜");
        Log.e("TAG","盘子送回指定的地点");
    }
}
