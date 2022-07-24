enum class LicenseStatus {
    UNQUALIFIED,
    LEARNING,
    QUALIFIED;

    //在有驾照的情况下，我要知道你的驾驶证编号
    //var licenseId: String? = null
}

class Driver(var status: LicenseStatus) {

    fun checkLicense(): String {

        //LicenseStatus.UNQUALIFIED.licenseId
        return when(status){
            LicenseStatus.UNQUALIFIED -> "没资格"
            LicenseStatus.LEARNING -> "在学"
            LicenseStatus.QUALIFIED -> "有资格"
        }
    }
}