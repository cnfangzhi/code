import java.io.File

fun main() {
    // takeIf true 返回自身， false 返回null
    var fileContents = File("D://i have a dream_copy.txt")
        .takeIf { it.exists() }
        ?.readText()

    //没有takeIf的情况
    val file = File("D://i have a dream_copy.txt")
    if(file.exists()){
        fileContents = file.readText()
    }


    fileContents = File("D://temp.txt")
        .takeUnless { it.isHidden }
        ?.readText()

    println(fileContents)
}