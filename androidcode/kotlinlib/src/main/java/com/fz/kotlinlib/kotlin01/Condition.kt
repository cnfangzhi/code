
fun main() {
    val age = 3
    if (age in 0..3){
        println("婴幼儿")
    }else if(age in 3..12){
        println("少儿")
    }else{
        println("青少年")
    }

    if(age !in 1..3){

    }

    // 1..5 [1,5]前闭后闭
    for (i in 1..5) {
        println(i)
    }
    val school = "0小学"
    val level = when(school){
        "学前班" -> "幼儿"
        "小学" -> "少儿"
        "中学" -> "青少年"
        else -> {
            println("未知")
        }
    }

    println(level)

}
