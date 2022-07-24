fun main() {
    val mutableList = mutableListOf("Jason", "Jack", "Jacky")

    mutableList += "Jimmy"
    mutableList -= "Jacky"
    println(mutableList)

    mutableList.removeIf { it.contains("Jack") }
    println(mutableList)
}