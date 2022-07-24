fun main1() {
    /*val total = "Mississippi".count({letter ->
        letter == 's'
    })
    println(total)*/

    //声明一个变量，等于一个函数，变量是有类型，就是函数的类型
    //函数的类型由参数和返回值决定
    /*val blessingFunction:(String) ->String = {name ->
        val holiday = "New Year."
        "$name, Happy $holiday"
    }*/

    //it关键字
    /*val blessingFunction:(String) ->String = {
        val holiday = "New Year."
        "$it, Happy $holiday"
    }*/

    /*val blessingFunction = {
        val holiday = "New Year."
        "Happy $holiday"
    }*/

    /*val blessingFunction = {name:String,year:Int ->
        val holiday = "New Year"
        "$name, Happy $holiday $year"
    }

    println(blessingFunction("Jack",2027))*/

    //定义匿名函数
    /*val getDiscountWords = {goodsName: String, hour:Int ->
        val currentYear = 2027
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }

    showOnBoard("卫生纸",getDiscountWords)*/

    /*showOnBoard("卫生纸",{goodsName: String, hour:Int ->
        val currentYear = 2027
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    })*/

    /*showOnBoard("卫生纸"){goodsName: String, hour:Int ->
        val currentYear = 2027
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }*/

}

//显示促销的文案，文案由另外一个函数生成
/*
inline fun showOnBoard(goodsName: String, getDiscountWords: (String,Int) ->String){
    val hour = (1..24).shuffled().last()
    println(getDiscountWords(goodsName,hour))
}*/

