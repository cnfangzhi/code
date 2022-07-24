import com.fz.kotlinlib.kotlin01.MyJava

fun doSomething(age:Int, flag:Boolean):String{
    return "result"
}

// Unit函数 没有返回值的函数, Unit可以省略
fun fix(name:String, age:Int = 2):Unit{
    println(name + age)
}

 fun `**~special function with weird name~**`(){
     println("I am weird")
 }


fun main() {
    doSomething(20,false)
    println(fix(age=5,name="jack"))

    // kotlin 可以使用空格和特色字符对函数命名，不过要用反引号
    `**~special function with weird name~**`()

    // is 是kotlin的关键字，不能作为函数名，
    // 为了支持Kotlin和Java互操作，使用反引号的函数名就可以避免任何冲突
    MyJava.`is`()

    // TODO函数返回Nothing类型
    TODO("nothing")
}



