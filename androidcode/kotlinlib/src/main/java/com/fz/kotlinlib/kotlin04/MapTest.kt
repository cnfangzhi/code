fun main() {
    val map = mapOf("Jack" to 20, "Jason" to 18, "Jacky" to 30)
    println(map)

    mapOf(Pair("Jack",20), Pair("Jason",18))

    println(map["Jack"])

    //map.getValue("Jimmy")
    map.getOrElse("Jimmy"){"Unknown"}
    map.getOrDefault("Jimmy","Unknown")

    map.forEach{
        println("${it.key},${it.value}")
    }

    map.forEach{(key,value) ->
        println("$key,$value")
    }

}