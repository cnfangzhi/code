fun main() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
        .map { animal -> "A baby $animal"}
        .map { baby -> "$baby,with the cutest little tail ever!" }
    println(animals) // 原集合没有被修改
    println(babies)

    // map 返回的新集合可以是不同类型
    val animalsLength = animals.map { it.length }
    println(animalsLength)

    //List<String>  List<List<String>>
}