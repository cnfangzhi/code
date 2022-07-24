package com.fz.kotlinlib.kotlin06

// 数据类， 专门设计用来存储数据的类
// 提供了toString、equals、hashCode的个性给实现
/*
* 使用数据类的条件
* 1、数据类必须有至少带一个参数的主构造函数
* 2、数据类主构造函数的参数必须是val或var
* 3、数据类不能使用abstract、open、sealed和inner修饰符
* */
data class Coordinate(var x: Int, var y: Int) {
    val isInBounds = x > 0 && y > 0

    // 运算符重载
    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}

fun main() {
    println(Coordinate(10,30))

    println(Coordinate(10,30) == Coordinate(10,30))

    // 数据类会自动为所有定义在主构造函数的属性添加对于的组件函数
    // 子定义组件函数：PlayerScore.kt
    val (x,y) = Coordinate(10, 30)
    println(x)
    println(y)

    // 数据类还提供了copy函数，方便复制对象
    var a = Coordinate(10,30)
    var b = a.copy()
    println(b)
    var c = a.copy(x = 11)
    println(c)

    val c1 = Coordinate(10, 20)
    val c2 = Coordinate(20, 30)

    println(c1 + c2)
}