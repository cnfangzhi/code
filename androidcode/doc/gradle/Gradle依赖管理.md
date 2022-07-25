## Gradle依赖管理



### Gradle资源库

在Gradle中存储模块的地方就叫做资源库。

- 定义了资源库之后，Gradle就知道怎么样查找和检索模块。资源库有两种方式：本地库和远程库。
- 在运行时，如果相应的任务需要，那么Gradle就需要定位依赖的声明，依赖可能需要从远程库下载，也可能从本地库检索或者是在多项目构建中的其他项目。这个过程就叫做依赖解析。
- 一旦解析，解析机制就会存储依赖的底层文件作为本地缓存，之后的构建会重用这些文件，而不用再到远程库下载。
- 模块还能提供一些其他的元数据，元数据是描述模块更详细信息的数据，比如在资源库中的坐标，项目的信息等。(group, name, version)



### 添加依赖仓库

在build.gradle中使用allprojects{}对所有的工程进行配置，使用repositories{}添加依赖仓库。

- google()：添加一个在Google 的 Maven 存储库中查找依赖项的存储库

- mavenCenteral()：添加一个在 Maven 中央存储库中查找依赖项的存储库。

- jcenter()添加一个在 Bintray 的 JCenter 存储库中查找依赖项的存储库。

  注意jecnter即将关闭，改用mavenCentral。如果有自己发布在jcenter的依赖库，需要迁移到mavenCentral。AS高版本中也默认的将jcenter()改成了mavenCenteral()。

- mavenLocal()：添加一个在本地Maven 缓存中查找依赖项的存储库。

- maven{}：指定某个maven仓库的地址，使用url(path)方法来添加。

- ivy{}：指定某个ivy仓库地址，使用url(path)方法来添加。



### Gradle依赖范围

在Gradle构建脚本中开发者可以把依赖定义到不同的范围中，比如编译源码或者执行测试。在Gradle中依赖的范围叫依赖项配置。

Gradle插件内置了几种方式的依赖项配置：

- implementation、api、compileOnly、runtimeOnly、annotationProcessor、lintChecks、lintPublish ...
- apk/compile/provided已被废弃。

在build.gradle中使用dependencies{}添加依赖项配置。



### 自定义依赖项配置

添加自定义依赖项配置，就可以使用该依赖项配置添加依赖：

```
configurations {
    abc {
        println "abc"
    }
}
// 在dependencies{}中使用：abc'androidx.core:core-ktx:1.2.0'
```



### implementation

Gradle会将依赖项添加到编译类路径，并将依赖项打包到构建输出。不过，当您的模块配置implementation依赖项时，会让Gradle了解您不希望该模块在编译时将该依赖项泄露给其他模块。也就是说，其他模块只有在运行时才能使用该依赖项。

使用此依赖项配置代替api或compile（已弃用）可以显著缩短构建时间，因为这样可以减少构建系统需要重新编译的模块数。例如，如果implementation依赖项更改了其API，Gradle只会重新编译该依赖项以及直接依赖于它的模块。大多数应用和测试模块都应使用此配置。



### api

Gradle会将依赖项添加到编译类路径和构建输出。当一个模块包含 api 依赖项时，会让 Gradle 了解该模块要以传递方式将该依赖项导出到其他模块，以便这些模块在运行时和编译时都可以使用该依赖项。

此配置的行为类似于 compile（现已弃用），但使用它时应格外小心，只能对您需要以传递方式导出到其他上游消费者的依赖项使用它。这是因为，如果api依赖项更改了其外部API，Gradle会在编译时重新编译所有有权访问该依赖项的模块。因此，拥有大量的api依赖项会显著增加构建时间。除非要将依赖项的API公开给单独的模块，否则库模块应改用implementation依赖项。



### annotationProcessor

如需添加对作为注解处理器的库的依赖，您必须使用 annotationProcessor配置将其添加到注解处理器的类路径。这是因为，使用此配置可以将编译类路径与注释处理器类路径分开，从而提高构建性能。如果Gradle在编译类路径上找到注释处理器，则会禁用避免编译功能，这样会对构建时间产生负面影响（Gradle5.0 及更高版本会忽略在编译类路径上找到的注释处理器）。

如果JAR文件包含以下文件，则Android Gradle插件会假定依赖项是注释处理器：

META-INF/services/javax.annotation.processing.Processor。 如果插件检测到编译类路径上包含注解处理器，则会产生构建错误。



### compileOnly

Gradle只会将依赖项添加到编译类路径（也就是说，不会将其添加到构建输出）。如果您创建Android模块时在编译期间需要相应依赖项，但它在运行时可有可无，此配置会很有用。

如果您使用此配置，那么您的库模块必须包含一个运行时条件，用于检查是否提供了相应依赖项，然后适当地改变该模块的行为，以使该模块在未提供相应依赖项的情况下仍可正常运行。这样做不会添加不重要的瞬时依赖项，因而有助于减小最终APK的大小。此配置的行为类似于provided（现已弃用）。



### 查看模块依赖项

要想查看整个项目的依赖传递关系，使用命令：

- gradlew app:dependencies--configuration releaseRuntimeClasspath。
- x.x.x (*) 该依赖已经有了，将不再重复依赖。
- x.x.x -> x.x.x 该依赖的版本被箭头所指的版本代替。
- x.x.x -> x.x.x(*)该依赖的版本被箭头所指的版本代替，并且该依赖已经有了，不再重复依赖。



![releaseRuntimeClasspath](pic\releaseRuntimeClasspath.png)

