fun main() {
    val getDiscountWords = configDiscountWords()
    println(getDiscountWords("牙膏"))
}

//脚本  Package
//架构设计的时候，分模块，分类，作用域（访问权限）
fun configDiscountWords():(String) -> String{
    val currentYear = 2027
    val hour = (1..24).shuffled().last()
    return {goodsName:String ->
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }
}


