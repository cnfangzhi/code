package com.fz.gradle.groovy

//class HelloGroovy {
//
//    默认public
//    static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            System.out.print("ha ")
//        }
//        System.out.print("hello Groovy!")
//    }
//
//    // var
//    def test() {
//        "hello Groovy!"
//    }
//
//}

for (i in 0..2) {
    print('ho ')
}
println('Merry Groovy')

0.upto(2) {
    print("$it")
}

//println("java -version".execute().text)
println("git  --help".execute().text)


3.times {
    //print "ha "
    print it
}
println "hello Groovy!"

//Closure c = {
//
//}

0.step(10,2,{it->
    println it
})

// 安全导航操作符
def foo(str) {
    str?.reverse()
}
//
println foo("eez")
println foo(null)

// 异常处理
def sleep(){
    Thread.sleep(1000)
}




//class A {
//    static A test1() {
//        println("test1")
//        this
//    }
//
//    static A test2() {
//        rintln("test2")
//        this
//    }
//}
//
//A.test1().test2()


