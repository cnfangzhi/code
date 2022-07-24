fun main() {

    val result = listOf("Jack","Jimmy","Rose","Tom")
        .filter { it.contains("J") }

    println(result)


    val items = listOf(
        listOf("red apple", "green apple", "blue apple"),
        listOf("red fish", "blue fish"),
        listOf("yellow banana", "teal banana")
    )

    val redItems = items.flatMap { it.filter { it.contains("red") } }
    println(redItems)

    //除了1和它本身，不能被任何数整除的数
    //取模等于0，说明能够整除，如果没有一个是等于0的，说明是素数
    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = numbers.filter { number ->
        (2 until number).map { number % it }
                .none { it == 0 }
    }
    println(primes)

}