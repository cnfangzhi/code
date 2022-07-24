fun main() {
    // flatMap函数操作一个集合的集合，将其中 多个集合中元素合并后返回一个包含所有元素的单一集合
    val result = listOf(listOf(1,2,3), listOf(4,5,6)).flatMap { it }
    println(result)
}