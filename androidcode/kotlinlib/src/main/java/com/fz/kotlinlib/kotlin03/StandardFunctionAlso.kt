import java.io.File

fun main() {
    var fileContents:List<String>
    File("D://temp.txt")
        .also {
            println(it.name)
        }.also {
            fileContents = it.readLines()
        }

    println(fileContents)
}