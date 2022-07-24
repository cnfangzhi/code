/*
fun main() {
    showOnBoard("卫生纸",::getDiscountWords)
}

fun getDiscountWords(goodsName: String, hour:Int):String{
    val currentYear = 2027
    return "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
}

fun showOnBoard(goodsName: String, getDiscountWords: (String,Int) ->String){
    val hour = (1..24).shuffled().last()
    println(getDiscountWords(goodsName,hour))
}*/
