package com.fz.kotlinlib.kotlin06

// 枚举类
enum class Direction {
    EAST,
    WEST,
    SOUTH,
    NORTH
}

fun main() {
    println(Direction.EAST)
    println(Direction.EAST is Direction)
}