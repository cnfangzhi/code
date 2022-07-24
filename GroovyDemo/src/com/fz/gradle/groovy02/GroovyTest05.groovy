package com.fz.gradle.groovy02

// MOP元编程

// 方法拦截实现：1. implements GroovyInterceptable

class Person implements GroovyInterceptable {

    def func() {
        System.out.println "I have a dream!"
    }

    @Override
    Object invokeMethod(String name, Object args) {
        //println "invokeMethod"
        System.out.println "$name invokeMethod"
        //respondsTo(name) //判断方法是否存在
        if (metaClass.invokeMethod(this, 'respondsTo', name, args)) {
            System.out.println "$name 方法存在"
            System.out.println "$name 执行前.."
            metaClass.invokeMethod(this, name, args)
            System.out.println "$name 执行后.."
        }
    }
}

new Person().func()

