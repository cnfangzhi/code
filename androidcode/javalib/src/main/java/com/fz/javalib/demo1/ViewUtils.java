package com.fz.javalib.demo1;


import java.lang.reflect.Field;

/**
 * Created by fz on 2017/9/4.
 */
public class ViewUtils {
    public static void inject(MainActivity activity) {
        // 1.获取所有的属性
        Field[] fields = activity.getClass().getDeclaredFields();
        // 2.过滤关于 ViewById 属性
        for (Field field : fields) {
            ViewById viewById =  field.getAnnotation(ViewById.class);
            if(viewById != null){
                // 3.findViewById
                View view = activity.findViewById(viewById.value());
                // 4.反射注入
                field.setAccessible(true);
                try {
                    // activity 属性所在类，view 代表的是属性的值
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
