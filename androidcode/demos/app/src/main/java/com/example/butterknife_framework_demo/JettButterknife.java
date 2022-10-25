package com.example.butterknife_framework_demo;

import android.app.Activity;

public class JettButterknife {
    public static void bind(Activity activity){
        String name=activity.getClass().getName()+"_ViewBinding";
        try{
            Class<?> aClass=Class.forName(name);
            IBinder iBinder=(IBinder)aClass.newInstance();
            iBinder.bind(activity);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
