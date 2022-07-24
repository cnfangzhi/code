package com.fz.kotlinlib.kotlin06

data class Student(var name: String, val age: Int) {
    var score = 10
    private val hobby = "music"
    val subject:String
    init {
        println("initializing student")
        subject = "math"
    }
    constructor(_name: String):this(_name,10){
        score = 20
    }

    override fun toString(): String {
        return "Student(name='$name', age=$age, score=$score," +
                " hobby='$hobby', subject='$subject')"
    }

}

fun main() {
    var s = Student("Jack")
    val copy = s.copy("Rose")
    println(s)
    println(copy)
}