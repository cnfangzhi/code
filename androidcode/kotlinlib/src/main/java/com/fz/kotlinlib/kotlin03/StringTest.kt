package com.fz.kotlinlib.kotlin03

const val NAME = "Jimmy's friend"
const val NAMES = "jack,jacky,jason"

fun main() {
    val index = NAME.indexOf('\'')
    val str = NAME.substring(0 until index)
    println(str)

    val data = NAMES.split(',')
    println(data)
    //解构赋值
    val (origin,dest,proxy) = NAMES.split(',')
    println("$origin $dest $proxy")

    val str1 = "The people's Republic of China."
    val str2= str1.replace(Regex("[aeiou]")){
        when(it.value){
            "a" -> "8"
            "e" -> "6"
            "i" -> "9"
            "o" -> "1"
            "u" -> "3"
            else -> it.value
        }
    }
    println(str1)
    println(str2)

    //字符串不可变
    val str3 = "Jason"
    val str4 = "jason".capitalize()

    println("$str3 $str4")
    println(str3 == str4) // ==相当于Java的equals
    println(str3 === str4) // ===检查两个变量是否指向内存堆上的同一对象

    "The people's Republic of China.".forEach {
        print("$it*")
    }
}