package com.example.annotation_demo_02;

import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InjectUtils {
    public static void inject(Object context){
        injectClick(context);
    }
    private static void injectClick(Object context) {
        Class<?> clazz=context.getClass();
        Method[] methods=clazz.getDeclaredMethods();

        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<?> annotationClass = annotation.annotationType();
                EventBase eventBase=annotationClass.getAnnotation(EventBase.class);
                //判断是不是事件处理程序  onClick  onLongClink
                if(eventBase==null){
                    continue;
                }
//                btn.setOnClickListener（new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                });
                //1.setOnClickListener 订阅关系
//                String listenerSetter();
                String listenerSetter=eventBase.listenerSetter();
                //2.new View.OnClickListener()  事件本身
//                Class<?> listenerType();
                Class<?> listenerType=eventBase.listenerType();
                //3.事件处理程序
//                String callbackMethod();
                String callBackMethod=eventBase.callbackMethod();

                //得到3要素之后，就可以执行代码了
                Method valueMethod=null;
                try {
                    valueMethod=annotationClass.getDeclaredMethod("value");
                    int[] viewId=(int[])valueMethod.invoke(annotation);
                    for (int id : viewId) {
                        //为了得到Button对象,使用findViewById
                        Method findViewById=clazz.getMethod("findViewById",int.class);
                        View view=(View)findViewById.invoke(context,id);
                        if(view==null){
                            continue;
                        }
                        //context===activity   click=method
                        ListenerInvocationHandler listenerInvocationHandler=new ListenerInvocationHandler(context,method);
                        //new View.OnClickListener()
                        Object proxy=Proxy.newProxyInstance(listenerType.getClassLoader(),new Class[]{listenerType},listenerInvocationHandler);

                        //   view.setOnClickListener（new View.OnClickListener()）
                        Method onClickMethod=view.getClass().getMethod(listenerSetter,listenerType);
                        onClickMethod.invoke(view,proxy);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


            }

        }
    }
}













