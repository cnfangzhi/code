fun main() {
    // let会返回lambda的最后一行
    val result = listOf(3,2,1).first().let{
        it * it
    }
    println(result)

    //没有let函数
    //如果有中间变量，if else考虑let函数
    val firstElement = listOf(3,2,1).first()
    val result2 = firstElement * firstElement
    println(result2)

    println(formatGreeting("jack"))
    println(formatGreeting(null))
}

fun formatGreeting(guestName:String?):String{
    return guestName?.let{
        "Welcome, $it."
    } ?: "What's your name?"
}

//不用let
fun formatGreeting2(guestName:String?):String{
    return if(guestName != null){
        "Welcome, $guestName."
    }else{
        "What's your name?"
    }
}