import kotlin.math.roundToInt

fun main() {
    //val number1 = "8.98".toInt()
    val number2 = "8.98".toIntOrNull() ?: 3
    println(number2)

    val s = "%.2f".format(8.956756)
    println(s)

    println(8.956756.toInt())
    println(8.956756.roundToInt())

}