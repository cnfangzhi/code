fun Int.isPrime(): Boolean {
    (2 until this).map {
        if (this % it == 0) {
            return false
        }
    }
    return true
}

fun main() {
    //你想产生头1000个素数
    //假定0-5000之内，可以找到1000个素数
    val toList = (1..5000).toList().filter { it.isPrime() }.take(1000)
    println(toList.size)
    // generateSequence 接受一个初始种子值seed，每次调用生产函数产生下一个值
    val oneTousandPrimes = generateSequence(2) { value ->
        value + 1
    }.filter { it.isPrime() }.take(1000)
    println(oneTousandPrimes.toList().size)

}