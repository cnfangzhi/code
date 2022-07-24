fun main() {
    val mutableSet = mutableSetOf("Kotlin", "Java", "Scala")
    mutableSet += "Groovy"

    // 集合转换
    println(listOf("Jack", "Jason", "Jacky","Jacky").toSet().toList())

    //快捷函数，去重
    println(listOf("Jack", "Jason", "Jacky","Jacky").distinct())

}