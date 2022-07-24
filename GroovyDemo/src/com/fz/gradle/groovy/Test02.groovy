package com.fz.gradle.groovy

// 函数与闭包

def closure = {
        // 1.默认能够接受一个参数，这个参数可以直接使用it
        //->  2.使用这种方式，闭包不能再传入参数
    a = 1, b = 2, c -> // 3.定义多个参数，并且可以使用方法一样去设置默认参数值
        println "a=$a b=$b c=$c"
}

//closure()
closure(4, 5, 6)
closure(30)
println closure.class

// 4.闭包可以作为方法的参数
def func(closure) {
    closure()
}
func {
    // 闭包执行的代码
    println "call"
}

// 5.类当中如果定义了call方法，可以直接使用对象()去调用call方法
class Action {
    void call(a) {
        println "call $a"
    }
}
def a = new Action()
a(111)

// 6.Closure比较重要的成员变量
//Object delegate;
//Object owner;
//Object thisObject;
//int resolveStrategy = OWNER_FIRST;
//Class[] parameterTypes;
//int maximumNumberOfParameters;

def closure2 = {
    int aa, int b ->
        println aa.getClass()
        println b.getClass()
}
closure2(1, 2)
println closure2.parameterTypes
println closure2.maximumNumberOfParameters

def closure3 = {
    println "this is" + this
    println "owner is" + owner
    println "delegate is" + delegate
}
closure3()

class Test {
//    static def closure2 = {
//        println "this is" + this
//        println "owner is" + owner
//        println "delegate is" + delegate
//    }

    def closure1 = {
        def closure2 = {
            // this:Test@2b76ff4e，定义它的时候的类的this，当它是static时就是class对象
            println "this is" + this
            // owner:Test$_closure1@8c3619e，定义它的时候的类的对象
            println "owner is" + owner
            // delegate:Test$_closure1@8c3619e，默认就是owner, 但是代理可以修改
            println "delegate is" + delegate
        }
        closure2()
    }
}

new Test().closure1()


class Test2 {
    def func() {
        println "Test2 func"
    }
}

def func() {
    println "Script func"
}
def closure4 = {
    func()
}
//closure()
closure4.delegate = new Test2()// 优先选择的是owner
//* @see groovy.lang.Closure#DELEGATE_FIRST
//* @see groovy.lang.Closure#DELEGATE_ONLY
//* @see groovy.lang.Closure#OWNER_FIRST
//* @see groovy.lang.Closure#OWNER_ONLY
//* @see groovy.lang.Closure#TO_SELF
closure4.resolveStrategy=Closure.DELEGATE_ONLY
closure4()
