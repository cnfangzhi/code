import java.io.File

fun main() {
    val file = File("D://temp.txt")
    // 用法和apply差不多，区别：apply返回自身，run返回lambda结果
    val result = file.run {
        readText().contains("great")
    }
    println(result)

    val result2 = "The people's Republic of China.".run(::isTooLong)
    //isTooLong("The people's Republic of China.")

    //函数式编程，灵活
    // 使用run执行函数引用
    "The people's Republic of China."
        .run (::isTooLong)
        .run (::showMessage)
        .run (::println)
}

fun isTooLong(name:String) = name.length >= 10

fun showMessage(isLong:Boolean):String{
    return if(isLong){
        "Name is too long."
    }else{
        "Please rename."
    }
}