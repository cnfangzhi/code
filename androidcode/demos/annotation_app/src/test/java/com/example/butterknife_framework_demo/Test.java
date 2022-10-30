package com.example.butterknife_framework_demo;

import androidx.annotation.DrawableRes;
import androidx.annotation.IntDef;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test {

    public static void setDrawable(@DrawableRes int id) {

    }

    public static void main(String... args) {
        setDrawable(R.drawable.ic_launcher_background);

        setCurrentDay(WeekDay.SUNDAY);

        setCurrentDay(SUNDAY);
    }


    private static WeekDay mCurrentDay;
    //每一个成员就是一个Wek对象
    enum WeekDay {
        SUNDAY, MONDAY
    }

    private static int mCurrentIntDay;
    private static final int SUNDAY = 0;
    private static final int MONDAY = 1;


    @IntDef({SUNDAY, MONDAY})
    @Target({ ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface WekDay {  //注解

    }

    public static void setCurrentDay(WeekDay currentDay) {
        mCurrentDay = currentDay;
    }

    public static void setCurrentDay(@WekDay int currentDay) {
        mCurrentIntDay = currentDay;
    }



}
