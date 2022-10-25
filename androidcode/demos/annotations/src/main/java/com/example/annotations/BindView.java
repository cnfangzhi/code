package com.example.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解，单独是没有意义的
 * 注解+APT 用于生成一些Java文件 butterknife dagger2 hilt databinding
 * 注解+代码埋点 AspactJ arouter
 * 注解+反射 XUtil， Lifecycle
 * @BindView(R.id.?)
 * TextView tvText;
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface BindView {
    int value();
}
