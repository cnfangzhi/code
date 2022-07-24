
fun main() {
    test()
}

fun test() {

    var str = getStr()
    // ? 如果str为null，不调用count
    var i = str?.count()
    println(i)
    println(str)
}


fun getStr():String?{
    return null
}


fun test2() {
    // 带let的安全调用
    var str = getStr()?.let{
        if(it.isNotBlank()){
            it.capitalize()
        }else{
            "butterfly"
        }
    }

    println(str)
}



fun test3() {
    // !! 非空断言操作符 会抛出KotlinNullPointerException
    val str = getStr()
    val i = str!!.count()
    println(i)
    println(str)
}

fun main2() {
    var str = readLine()
    // 使用if判断null志
    if(str != null){
        str = str.capitalize()
    }else{
        println("为null.")
    }

    // ?: 空合并操作符： 如果左边的值为null，就使用右边的值
    val strWithSafe1 = str ?: "butterfly"

//    str = str?.capitalize()?.plus(" is great.");

    //let代替if，else，?: 空合并操作符（elvis）缺损值
    val strWithSafe = str?.let{ it.capitalize()} ?: "butterfly"

    println(str)
}
