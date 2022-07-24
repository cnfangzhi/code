class PlayerScore(val experience: Int, val level: Int) {
    // 组件函数
    operator fun component1() = experience
    operator fun component2() = level
    operator fun component3() = 111
}

fun main() {
    val (x, y, z) = PlayerScore(10, 4)
    println(x)
    println(y)
    println(z)

}