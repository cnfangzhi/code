package com.fz.kotlinlib.kotlin05

import kotlin.math.absoluteValue
// 主构造函数
class Player(
        _name: String, // 临时变量，命名通常以下划线开头
        var age: Int = 20, // 指定默认值
        val isNormal: Boolean
) {
    // field 覆盖get set
    var name = "abc"
        get() = field.capitalize()
        set(value){
            field = value.trim()
        }

//    var age = 10
//        get() = field.absoluteValue
//        private set(value) {
//            field = value.absoluteValue
//        }

    val rolledValue
        get() = (1..60).shuffled().first()

    var words:String? = "hEllO"

    // lateinit 延迟初始化
    lateinit var equipment: String

    fun ready(){
        equipment = "sharp knife"
    }

    fun battle(){
        // isInitialized 检查变量是否完成初始化
        if(::equipment.isInitialized) println(equipment)
    }

    // 惰性初始化，使用时才初始化
    val config by lazy { loadConfig() }

    private fun loadConfig(): String {
        println("loading...")
        return "xxx"
    }

    //初始化块
    init {
        //先决条件函数
        println("初始化块")
        println(_name)
        println(age)
        this.age = 100
        require( age > 0) {"age must be positive."}
        require(name.isNotBlank()) {"player must have a name."}
    }

    //次构造函数
    constructor(name: String) : this(name, 100, false)

    constructor(name: String, age: Int) : this(name, age, false) {
        println("次构造函数")
        println(this.age)
        this.name = name.toUpperCase()
    }

    constructor() : this("name", 100, false)

    fun fix(){
        //words = words?.toLowerCase()?.capitalize()
        words = words?.let {
            it.toLowerCase().capitalize()
        }
    }

}

fun main() {
    /*
    * 初始化顺序
    * 1、主构造函数里声明的属性
    * 2、类级别的属性赋值
    * 3、init初始化块里的属性赋值和函数调用
    * 4、次构造函数里的属性赋值和函数调用
    * */
    val player = Player("haha", 11)
    player.name = " abc "
    //println(player.name)

    //player.age = -20
    //println(player.age)

    println(player.rolledValue)
    println(player.rolledValue)

    player.fix()
    println(player.words)
}