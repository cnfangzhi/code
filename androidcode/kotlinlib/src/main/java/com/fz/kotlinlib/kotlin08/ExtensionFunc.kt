package com.fz.kotlinlib.kotlin08

// 重命名扩展
import java.io.File
import com.fz.kotlinlib.kotlin08.randomTake as randomizer

// 扩展属性
val String.numVowels
    get() = count { "aeiou".contains(it) }

//给字符串追加若干个感叹号
fun String.addExt(amount: Int = 1) = this + "!".repeat(amount)

fun Any.easyPrint() = println(this)

fun Any.easyPrint2(): Any {
    println(this)
    return this
}

// 泛型扩展函数
fun <T> T.easyPrint3(): T {
    println(this)
    return this
}

// 可空类扩展
// infix关键字：适用于单个参数的函数，调用时可以不要 点 和 括号
infix fun String?.printWithDefault(default: String) = print(this ?: default)

inline fun File.apply(block: File.() -> Unit): File {
    block()
    return this
}

fun main() {
    println("abc".addExt(2))
    "abc".easyPrint()
    15.easyPrint()
//    "abc".easyPrint2().addExt2(2).easyPrint2()

    "abc".easyPrint3().addExt(2).easyPrint()

    // let函数也是泛型扩展函数
    val i = "abc".let {
        50
    }

    "The people's Republic of China".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDefault "abc"

    val list = listOf("Jason", "Jack", "Tom")
    val set = setOf("Jason", "Jack", "Tom")

    list.randomizer()

    // 隐式调用
    val file = File("xx").apply {
        setReadable(true)
    }

    //这里分解一下
    //1.定义扩展函数
    fun File.ext(): Unit {
        setReadable(true)
    }
    //2.给block变量赋值
    val block = File::ext
    //3.传入apply函数
    File("xx").apply { block }
}
