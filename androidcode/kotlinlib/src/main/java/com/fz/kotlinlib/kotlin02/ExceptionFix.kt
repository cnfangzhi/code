
fun main() {
    var number: Int? = null
    try {
        //抛出异常
        //checkOperation(number)
        checkNotNull(number,{"操作不合法"})
        requireNotNull(number, {""})
        error(number)

        require(false, { "error" })
        assert(false, {"error"})

        number!!.plus(1)
    } catch (e: Exception){
        println(e)
    }

    //kotlin都是未检查异常
    //运行时异常 RuntimeException（未检查异常），非运行时异常 必须要处理（检查异常）
}

fun checkOperation(number: Int?){
    number ?: throw UnskilledException()
}

//自定义异常
class UnskilledException() : IllegalStateException("操作不合法")