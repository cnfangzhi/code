fun main() {
    val mutableList = mutableListOf("Jason", "Jack", "Jacky")
    mutableList.add("Jimmy")
    mutableList.remove("Jack")
    println(mutableList)

    listOf("Jason", "Jack", "Jacky").toMutableList()
    mutableList.toList()
}