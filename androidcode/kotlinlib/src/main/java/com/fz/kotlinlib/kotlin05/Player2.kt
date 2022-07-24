package com.fz.kotlinlib.kotlin05

// 嵌套类
// 如果一个类只对另一个类有用，可以使用嵌套类
class Player2 {
    class Equipment(var name: String) {
        fun show() = println("equipment:$name")
    }

    fun battle() {
        Equipment("sharp knife").show()
    }
}

fun main() {
    Player2.Equipment("AK47").show()
    Player2().battle()

}