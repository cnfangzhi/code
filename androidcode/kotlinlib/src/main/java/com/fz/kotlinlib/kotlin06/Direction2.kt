package com.fz.kotlinlib.kotlin06

enum class Direction2(private val coordinate : Coordinate) {
    EAST(Coordinate(1,1)),
    WEST(Coordinate(2,2)),
    SOUTH(Coordinate(3,3)),
    NORTH(Coordinate(4,4));

    fun updateCoordinate(playerCoordinate: Coordinate) =
        Coordinate(coordinate.x + playerCoordinate.x,
            coordinate.y + playerCoordinate.y)
}

fun main() {
    println(Direction2.EAST.updateCoordinate(Coordinate(10,20)))
}