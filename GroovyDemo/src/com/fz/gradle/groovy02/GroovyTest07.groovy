package com.fz.gradle.groovy02

// MOP方法注入
// JDK,GDK的类做扩展

// 1. 使用MetaClass来注入方法
class Person4 {
    def func() {
        System.out.println "I have a dream!"
    }
}

println Person4.metaClass // 注入前：org.codehaus.groovy.runtime.HandleMetaClass

Person4.metaClass.newFunc = {
    println "newFunc调用"
}
println Person4.metaClass // 注入后：groovy.lang.ExpandoMetaClass
new Person4().newFunc()

// 2.使用groovy.lang.ExpandoMetaClass来注入方法
def emc = new ExpandoMetaClass(Person4)
emc.func2 = {
    println "func2"
}
emc.initialize()
Person4.metaClass = emc
new Person4().func2()

// 3.使用分类注入方法
class StringUtils {

//    public static String isEmpty(){
//
//    }

    static def isNotEmpty(String self) {
        println "isNotEmpty"
        self != null && self.length() > 0
    }

}

class StringUtils2 {

    static def isNotEmpty(Integer self) {
        println "isNotEmpty2"
        self != null
    }
}

use(StringUtils, StringUtils2) {
    println "".isNotEmpty()
    println 1.isNotEmpty()
}

// 4.使用分类注入方法，写法2
@Category(String)
class StringUtils3 {
    def isNotEmpty() {
        println "isNotEmpty3"
        this != null && this.length() > 0
    }
}

use(StringUtils3) {
    println "".isNotEmpty()
}


//=================================================
// 运算符重载

class TestA {
    def plus(TestA newTestA) {
        // 处理业务
        println "plus"
    }
}
new TestA() + new TestA()

Integer.metaClass.plus = {
    int a ->
        "$delegate + $a"
}
println 1 + 2


//=====================

// Expando动态生成类
def e = new Expando(name: "Aaa", func: {
    println "func"
})

e.a = 123
println e.a
e.func()
println(e.class)

//123:Int