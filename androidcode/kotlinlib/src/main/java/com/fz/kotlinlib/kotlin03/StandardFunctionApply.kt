import java.io.File

fun main() {
    val file1 = File("D://temp.txt")
    file1.setReadable(true)
    file1.setWritable(true)
    file1.setExecutable(false)

    //file2接收者对象， apply会返回自身
    val file2 = File("D://temp.txt").apply {
        // 隐式调用
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }
}