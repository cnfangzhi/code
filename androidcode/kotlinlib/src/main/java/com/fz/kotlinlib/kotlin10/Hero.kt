@file:JvmName("Hero") // 指定编译类的名字

package com.fz.kotlinlib.kotlin10

import java.io.IOException

fun main() {
    val adversary = Jhava()
    println(adversary.utterGreeting())
    //平台类型
    val level = adversary.determineFriendshipLevel()
    level?.toLowerCase()

    adversary.hitPoints = 3
    println(adversary.hitPoints)

    handOverFood("apple")

    //Spellbook.MAX_SPELL_COUNT

    try {
        adversary.extendHandInFriendship()
    } catch (e: Exception) {
        println("Begone, foul beast!")
    }
}

fun makeProclamation() = "Greetings, beast!"

//调用者可以指定英雄左手或右手拿什么食物，或者使用默认的配置——左手拿浆果，右手拿牛肉。
// 在有默认参数值的方法中使用@JvmOverloads注解，则Kotlin就会暴露多个重载方法。
@JvmOverloads // 设计一个可能会暴露给Java使用的api时，记得使用JvmOverloads注解
fun handOverFood(leftHand: String = "berries", rightHand: String = "beef") {
    println("Mmmm... you hand over some delicious $leftHand and $rightHand")
}

@Throws(IOException::class) // 告诉Java调用者，这个函数会抛出某个异常
fun acceptApology() {
    throw IOException()
}

//添加一个translator的函数类型，接收一个字符串，
//将其改为小写字母，再大写第一个字符，最后打印结果。
val translator: (String) -> Unit = { utterance: String ->
    println(utterance.toLowerCase().capitalize())
}