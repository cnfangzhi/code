package com.fz.kotlinlib.kotlin07

// 接口中函数默认就是open的
interface Movable {
    // 接口中可以提供默认属性的getter方法和函数实现
    var maxSpeed: Int
        get() = (1..500).shuffled().last()
        set(value) {}

    var wheels: Int

    fun move(movable: Movable): String

    fun move2(movable: Movable): String {
        return "move2"
    }
}

// 接口属性和函数实现都要使用override
class Car(_name: String, override var wheels: Int = 4) : Movable {

    override var maxSpeed: Int
        get() = super.maxSpeed //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override fun move(movable: Movable): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
