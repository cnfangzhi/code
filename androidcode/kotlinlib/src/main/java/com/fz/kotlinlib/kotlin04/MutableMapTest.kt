fun main() {
    val mutableMap = mutableMapOf("Jack" to 20, "Jason" to 18, "Jacky" to 30)

    mutableMap += "Jimmy" to 30
    mutableMap.put("Jimmy",31)

    mutableMap.getOrPut("Jackson"){18}
    mutableMap.getOrPut("Jimmy"){18}
    println(mutableMap)
}