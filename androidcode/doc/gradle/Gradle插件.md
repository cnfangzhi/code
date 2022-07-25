## Gradle插件

### 什么是Gradle插件

Gradle插件是提供给gradle构建工具，在编译时使用的依赖项。插件的本质就是对公用的构建业务进行打包，以提供复用。

Gradle插件分为：脚本插件和二进制插件 (实现Plugin的类)。

Gradle插件通过apply方法引入到工程。



### 使用插件和脚本依赖项的区别

插件实现了一些列的任务，并且进行了组装，按照提供的API就可以直接使用。

而Gradle脚本依赖项，是提供实现的任务封装，需要自行组装。或者是用到的一些具体业务的封装。



### 自定义插件

实现gradle脚本，apply到指定工程。

实现自定义的插件类，继承Plugin，实现apply方法。

```
class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {
        println "MyPlugin apply"

        target.afterEvaluate {
            println target.tasks.getByName("packageDebug")
            target.task(type: Zip, "zipDebug") {
                archiveName "outputs4.zip"// 输出的文件名字
                destinationDir target.file("${target.buildDir}/custom")// 输出的文件存放的文件夹
                from target.tasks.getByName("packageDebug").outputs.files// 输入的文件
                target.tasks.getByName("packageDebug").outputs.files.each {
                    println it
                }
            }
        }
    }
}

apply plugin: MyPlugin
```

通过默认的buildSrc工程，直接实现插件的封装。在运行时，会自动打包成jar并进行依赖进来。