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



## Gradle构建机制

### settings.gradle

Gradle支持多工程构建，使用settings.gradle来配置添加子工程(模块)。

settings文件在初始化阶段执行，创建Settings对象，在执行脚本时调用该对象的方法。

Settings.include(String... projectPaths)：

- 将给定的目录添加到项目构建中，':app'表示文件相对路径，相当于'./app'文件夹。
- 多项目架构进行分层，把同层次的子工程放在同一文件夹下便于管理，使用':xxx:yyy'表示。



### build.gradle

build.gradle是项目构建文件，每个工程都有一个build.gradle文件。

build.gradle在配置阶段执行，并创建相应工程的Project对象，执行的代码可以直接调用该对象提供的方法或属性。



### Daemon(守护进程)

项目启动时，会开启一个client，然后启动一个daemon，通过client向daemon收发请求，项目关闭，client关闭，daemon保持启动，有类似项目再次部署时，会直接通过新的client访问已经启动的daemon，所以速度很快，默认daemon不使用3小时后关闭；不同项目兼容性考虑，也可使用--no-daemon启动项目，就没有速度优势了。

手动停止daemon：gradle wrapper --stop



### Gradle生命周期

#### Initialization

- Gradle支持单项目和多项目构建。在初始化阶段，Gradle确定哪些项目将参与构建，并为每个项目创建Project实例，一般我们不会接触到它。(比如解析settings.gradle)

#### Configuration

- 配置阶段，解析每个工程的build.gradle文件，创建要执行的任务子集和确定各种任务之间的关系，并对任务的做一些初始化配置。

#### Execution

- 运行阶段，Gradle根据配置阶段创建和配置的要执行的任务子集，执行任务。



### Gradle执行流程

![gradle执行流程](pic\gradle执行流程.png)



### Configuation阶段

解析每个Project中的build.gradle，解析过程中并不会执行各个build.gradle中的task。

经过Configration阶段，Project之间及内部Task之间的关系就确定了。一个Project包含很多Task，每个Task之间有依赖关系。Configuration会建立一个有向图来描述Task之间的依赖关系，所有Project配置完成后，会有一个回调project.afterEvaluate()，表示所有的模块都已经配置完了。



### gradle钩子函数

gradle在生命周期三个阶段都设置了相应的钩子函数调用。

使用钩子函数，处理自定义的构建：

- 初始化阶段：gradle.settingsEvaluated和gradle.projectsLoaded。(在settings.gradle中生效)

- ```
  // 初始化阶段：
  gradle.projectsLoaded {
      println "gradle.projectsLoaded"
  }
  gradle.settingsEvaluated {
      println "gradle.settingsEvaluated"
  }
  ```

- 配置阶段：project.beforeEvaluate和project.afterEvaluate；gradle.beforeProject、gradle.afterProject及gradle.taskGraph.taskGraph.whenReady。

- ```
  // Gradle提供的钩子函数
  // 配置阶段：
  gradle.beforeProject {
      println "gradle.beforeProject"
  }
  gradle.afterProject {
      println "gradle.afterProject"
  }
  gradle.taskGraph.whenReady {
      println "gradle.taskGraph.whenReady"
  }
  beforeEvaluate {
      // 在root无效
      println "beforeEvaluate"
  }
  afterEvaluate {
      println "afterEvaluate"
  }
  ```

- 执行阶段：gradle.taskGraph.beforeTask和gradle.taskGraph.afterTask。

  ​



### gradle构建监听

gradle可以设置监听，对各阶段都有相应的回调处理：

- gradle.addProjectEvaluationListener
- gradle.addBuildListener
- gradle.addListener：TaskExecutionGraphListener (任务执行图监听)，TaskExecutionListener(任务执行监听)，TaskExecutionListener、TaskActionListener、StandardOutputListener ...

```
// 为gradle设置监听
gradle.addProjectEvaluationListener(new ProjectEvaluationListener() {
    @Override
    void beforeEvaluate(Project project) {
        println "beforeEvaluate"
    }

    @Override
    void afterEvaluate(Project project, ProjectState state) {
        println "afterEvaluate"
    }
})
gradle.addBuildListener(new BuildListener() {
    @Override
    void settingsEvaluated(Settings settings) {

    }

    @Override
    void projectsLoaded(Gradle gradle) {

    }

    @Override
    void projectsEvaluated(Gradle gradle) {

    }

    @Override
    void buildFinished(BuildResult result) {

    }
})
```



### Project

build.gradle在配置阶段会生成project实例，在build.gradle中直接调用方法或属性，实则是调用当前工程project对象的方法或属性。

使用Project提供的Api，在多项目构建设置游刃有余：

- project(':app'){} 指定的project(这里是app) 配置
- allprojects{} 所有的project配置
- subprojects{} 所有的子project配置
- buildscript {} 此项目配置构建脚本类路径



### 属性扩展

使用ext对任意对象属性进行扩展：

- 对project进行使用ext进行属性扩展，对所有子project可见。
- 一般在root project中进行ext属性扩展，为子工程提供复用属性，通过rootProject直接访问。
- 任意对象都可以使用ext来添加属性：使用闭包，在闭包中定义扩展属性。直接使用=赋值，添加扩展属性。
- 由谁进行ext调用，就属于谁的扩展属性。
- 在build.gradle中，默认是当前工程的project对象，所以在build.gradle直接使用"ext="或者"ext{}"其实就是给project定义扩展属性。

使用gradle.properties以键值对形式定义属性，所有project可直接使用。





## Gradle任务

### task

task是gardle中最小的任务单元，任务之间可以进行复杂的操作（如动态创建任务，多任务间依赖调用等等)。gradle的执行其实就是由各种任务组合执行，来对项目进行构建的。

使用gradlew help命令，任何gradle项目都有一个该task，可以执行此命令观察taks执行的流程是否如预期。

可以使用工具查看，还可以通过 gradlewtasks 命令查看可运行任务。

- 使用gradlewtasks --all 命令查看所有任务。
- 使用gradlewA B 命令表示执行任务A和B，支持驼峰简写。



### 自定义任务

在build.gradle中自定义任务：

- task <任务名>{.. }，在Gradle5.x以上已经删除<<操作符这种写法。

- { ... }执行的是配置阶段的代码，执行阶段要处理的逻辑需要调用doFirst、doLast方法，在闭包中实现。doFirst{}表示任务执行开始时调用的方法，doLast{}表示任务执行结束调用的方法。

- task A(dependsOn:[B]){ .. } 表示任务A依赖于任务B，那么B执行在A之前。

- ```
  task A {
      println "configuration A"
      doFirst {
          println "doFirst A"
      }
  }

  task ("B") {
      println "configuration B"
      doLast() {
          println "doLast B"
      }
  }
  // 执行hello之前，先执行A， B
  task hello(dependsOn: [A, B]) {
      doLast() {
          println "doLast hello"
      }
  }
  // 执行A之前，先执行B，三种写法
  //A.dependsOn B
  //A.mustRunAfter B
  A.shouldRunAfter B

  task finalized {
      doLast {
          println "清理任务"
      }
  }
  // 执行完A后，执行清理任务
  A.finalizedBy finalized
  ```

- 自定义的任务默认分组到other中。

### 自定义任务类

task定义的任务其实就是DefaultTask的一种具体实现类的对象。

可以使用自定义类继承DeaflutTask：

- 在方法上使用@TaskAction注解，表示任务运行时调用的方法。

- 使用@Input表示对任务的输入参数。

- 使用@OutputFile表示任务输出文件。

- 使用inputs，outputs直接设置任务输入/输出项。

- 一个任务的输出项可以作为另一个任务的输入项 (隐式依赖关系)。

  ```
  class ZipTask extends DefaultTask {

  //    @Input
  //    @Optional
      // 表示可选
      String from

  //    @OutputFile
  //    @Optional
      // 表示可选
      File out

      ZipTask() {
          group "自定义任务"
          description "自定义任务描述"
          outputs.upToDateWhen {
              false//  增量构建，每次都会开启，不会跳过任务
          }
      }

      @TaskAction
      void fun() {
          println " @TaskAction fun()"
          println from
          println out

          //文件进行操作
          //inputs.files.first()
          println inputs.files.singleFile
          def inFile = inputs.files.singleFile

          def file = outputs.files.singleFile
          file.createNewFile()
          file.text = inFile.text
      }
  }

  task myTask(type: ZipTask) {
      from = "a/b/c" // 输入
      out = file("test.txt") // 输出
      inputs.file file('build.gradle')
      outputs.file file('test.txt')
  }
  ```



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