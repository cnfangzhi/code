## Gradle基础

### 环境配置

官方地址：https://gradle.org/releases/

去官网下载gradle或者从本地用户文件夹下的.gradle/wrapper/dists找到本地缓存的gradle开发工具包(注意带bin文件夹的这个grade-x.x)。

系统属性配置：

添加GRADLE_HOME：C:\Users\sheji\.gradle\wrapper\dists\gradle-6.5-all\gradle-6.5

添加Path：%GRADLE_HOME%\bin



### Hello Gradle!

在工程文件夹下，创建一个build.gradle文件：

```
task hello{

  println 'Hello, Gradle!'

}
```

打开cmd终端，移动到工程目录下，执行命令：> gradle -q hello

build.gradle是构建Project的核心文件，也是入口：

- 如果没有该文件，会出现not found in root project 'xxxxx' 提示异常。
- 必须要有一个可以运行的task，运行后自动生成.gradle文件夹下的内容。



### Gradle Wrapper

GradleWrapper用来配置开发过程中用到的Gradle构建工具版本。避免因为Gradle不统一带来的不必要的问题。

在工程目录下使用cmd命令生成wrapper：> gradle wrapper

标准的gradle工程目录：

- gradlew和gradlew.bat分别是Linux和Windows下的可执行脚本，具体业务逻辑是在/gradle/wrapper/gradle-wrapper.jar中实现，gradlew最终还是使用Java执行这个jar包来执行相关的Gradle操作的。



### gradle-wrapper.properties

该配置文件是gradle wrapper的相关配置：

- distributionBase：下载的Gradle压缩包解压后存储的主目录

- distributionPath：相对于distributionBase的解压后的Gradle压缩包的路径

- distributionUrl：Gradle发行版压缩包的下载地址

  -bin：二进制发布版。

  -all：bin基础上还包含了源码和文档。


- zipStoreBase：同distributionBase，只不过存放的是zip压缩包的
- zipStorePath：同distributionPath，只不过存放的是zip压缩包的

GradleUserHome: 默认路径在~/.gradle/ 



### Gradle命令行

gradlew -?/-h/-help 使用帮助。

gradlew tasks 查看所有可执行Tasks。

gradlew --refresh-dependencies assemble 强制刷新依赖。

gradlew cBC 等价与执行Task cleanBuildCache，这种通过缩写名快速执行任务。

gradlew:app:dependencies查找app工程依赖树。



