package com.fz.architect.design04.simple2;

import android.util.Log;

/**
 * Created by fz on 2017/9/30.
 */

public class StudentEat implements Eat {
    private Eat eat;
    public StudentEat(PersonEat eat){
        this.eat = eat;
    }

    @Override
    public void eat() {
        Log.e("TAG","点个菜");
        eat();
        Log.e("TAG","盘子送回指定的地点");
    }
}
