package com.fz.gradle.groovy02

// MOP方法拦截，方式2：使用MetaClass进行方法拦截

class Person3 {

    def func() {
        System.out.println "I have a dream!"
    }

//    @Override
//    Object invokeMethod(String name, Object args) {
//        return super.invokeMethod(name, args)
//    }
}

def person3 = new Person3()
// 这里拦截某个对象的某一个方法
//person3.metaClass.func = {
//    println "I have a new dream !!!"
//}
//person3.func()

// 等价与实现拦截接口
person3.metaClass.invokeMethod = {
    String name, Object args ->// invokeMethod(String name, Object args)
        println "$name 被拦截"
}
person3.func()
//new Person3().func()
//new Person3().func()
//new Person3().func()
//new Person3().func()
//new Person3().func()

Person3.metaClass.invokeMethod = {
    String name, Object args ->// invokeMethod(String name, Object args)
        println "$name 被拦截"
}
//person3.func()
//
//new Person3().func()
//new Person3().func()
//new Person3().func()
//new Person3().func()
//new Person3().func()

String.metaClass.invokeMethod = {
    String name, Object args ->
        println "String.metaClass.invokeMethod"
        MetaMethod method = delegate.metaClass.getMetaMethod(name)
        if (method != null && name == 'toString') {
            "zee"
        }
}
println "jason".toString()

