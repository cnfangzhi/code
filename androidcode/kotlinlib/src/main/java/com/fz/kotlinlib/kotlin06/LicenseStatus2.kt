// 密封类 声明一个密封类，需要在类名前面添加 sealed 修饰符
sealed class LicenseStatus2 {
    //无状态
    object UnQualified : LicenseStatus2()
    object Learning : LicenseStatus2()
    //有状态
    // 枚举类型的值集合也是受限的，但每个枚举常量只存在一个实例，
    // 而密封类的一个子类可以有可包含状态的多个实例。
    class Qualified(val licenseId: String) : LicenseStatus2()
}

class Driver2(var status: LicenseStatus2) {

    fun checkLicense(): String {
        return when (status) {
            is LicenseStatus2.UnQualified -> "没资格"
            is LicenseStatus2.Learning -> "在学"
            is LicenseStatus2.Qualified -> "有资格，驾驶证编号：${(this.status as LicenseStatus2.Qualified).licenseId}"
            else -> ""
        }
    }
}

fun main() {
    var status = LicenseStatus2.Qualified("2390323290")
    val driver = Driver2(status)
    println(driver.checkLicense())
}