package com.fz.kotlinlib.kotlin05

import java.io.File

// object:定义一个只产生一个实例的类-单例
// 对象声明
object ApplicationConfig {
    init {
        println("loading config...")
    }

    fun setSomething() {
        println("setSomething")
    }
}

open class Foo {
    open fun load() = "loading"
}

//伴生对象
open class ConfigMap{
    // 一个类里只能有一个伴生对象
    companion object{
        private const val PATH = "xxx"
        fun load() = "load $PATH"
    }

}

fun main() {
    ApplicationConfig.setSomething()
    println(ApplicationConfig)
    println(ApplicationConfig)
    // 对象表达式
    val p = object : Foo() {
        override fun load(): String {
            return "anonymous class load..."
        }
    }
    println(p.load())
    println(ConfigMap.load())

}