package com.fz.kotlinlib.kotlin05

// 类默认都是封闭的，要让某个类开放继承，必须使用open关键字修饰它
open class Product(val name: String) {
    fun description() = "Product：$name"

    // 函数重载，父类函数以open修饰，子类才能覆盖
    open fun load() = "Nothing..."
}

class LuxuryProduct : Product("Luxury"){
    override fun load() = "LuxuryProduct loading..."
}

fun sale(p: Product){
    println(p.load())
}

fun main() {
    val p:LuxuryProduct = LuxuryProduct()
    // is：检查对象的类型
    println(p is Product)
    println(p is LuxuryProduct)
    println(p is Any) // 每个类都会继承Any
    println(p)

    // as：类型转换
    sale((p as Product))
    sale(p)
}