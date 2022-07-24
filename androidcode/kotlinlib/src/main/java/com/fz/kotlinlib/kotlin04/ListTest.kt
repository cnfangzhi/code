fun main() {
    //只读
    val list = listOf("Jason", "Jack", "Jacky")
    println(list.getOrElse(4){"Unknown"})
    println(list.getOrNull(4) ?: "Unknown")
    println(list[2])
}