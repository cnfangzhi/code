package com.fz.gradle.groovy

def str1 = 'name'
def str4 = "name"
def str2 = "$str1:AA"
def str3 = """
$str1:AA"
$str2
"""
println("str1${str1.class}")  // str1class java.lang.String
println("str1${str4.class}")  // str1class java.lang.String
println("str2${str2.class}")  // str2class org.codehaus.groovy.runtime.GStringImpl
println("str3${str3.class}")  // str2class org.codehaus.groovy.runtime.GStringImpl

def mothod(Object obj) {
    1
}

def mothod(String str) {
    2
}

Object o1 = new Object()
Object o2 = 'aaa'
println("method ${mothod(o1)} is invoked") // method 1 is invoked
println("method ${mothod(o2)} is invoked") // method 2 is invoked

[0, 10]
(0..10).forEach{
    print(it)
}
println()
println('------------------------')

def array = [1, 2, 3]
println(array.class) // class java.util.ArrayList
int[] array2 = [1, 2, 3]
println(array2.class) // class [I
def array3 = [1, 2, 3] as int[]
println(array3.class) // class [I

def map = [a: 11, b: 12]
map.forEach{k, v ->
    println("key${k.class}, value=$v")
}
println(map['a'])

Integer.metaClass.add1000 {
    delegate + 1000
}
println(100.add1000())


class Car implements GroovyObject {
    def miles
    def year

    def getMiles() {
        println "getMiles"
        return miles
    }

    private void setMiles(miles) {
//        throw new IllegalAccessException("can not set")
        println "setMiles"
        this.miles = miles
    }

    void execute(x = 1, y = 2, z=3) {
        println "$x $y $z"
    }

//    void execute(a) {
//        println "$x $y $z"
//    }

}

def car = new Car()
car.miles = 20000
car.@year = 2027
println car.miles
//// 通过'.变量名'进行访问
println car.'miles'
def str = "year"
println car."$str"

// 1.Groovy对于private修饰的变量没有强制性
// 2.在类的构造方法中使用具名参数:
def carmap = [miles: 20000, year: 2021]
def car2 = new Car(miles: 20000, year: 2021)
def car3 = new Car(carmap)
// 它优先的是当成Map匹配构造方法，如果匹配不到，就无参构造方法，然后调用对应属性的getter/setter
println(car2.miles)
println(car3.miles)

// 3.方法不支持类似的具名参数
Car c = new Car()
//c.execute(x: 1, y: 2, z: 3, 2222, c: 111, 3333, a: 111, b: 222)
//c.execute( 1, 3, 6)
//c.execute()
c.execute(10)
c.execute(10, 20)
c.execute(10, 20, 30)

// 4.但是方法可以设置初始的默认值，注意方法重载


