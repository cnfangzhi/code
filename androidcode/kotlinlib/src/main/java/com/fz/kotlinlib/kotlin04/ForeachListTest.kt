fun main() {

    val list = listOf("Jason", "Jack", "Jacky")
    for (s in list) {
        println(s)
    }

    list.forEach{
        println(it)
    }

    list.forEachIndexed{index,item ->
        println("$index, $item")
    }

    // 通过_符号过滤不想要的元素
    val (origin, _, proxy) = listOf("Jason", "Jack", "Jacky")
}