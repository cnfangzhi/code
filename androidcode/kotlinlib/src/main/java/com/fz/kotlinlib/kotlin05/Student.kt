package com.fz.kotlinlib.kotlin05

class Student(_name: String, val age: Int) {
    var name = _name
    var score = 10
    private val hobby = "music"
    val subject: String

    init {
        println("initializing student")
        subject = "math"
    }

    constructor(_name: String) : this(_name, 10) {
        score = 20
    }


}

fun main() {
    Student("Jack")
}