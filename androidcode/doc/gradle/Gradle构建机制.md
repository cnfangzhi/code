Gradle构建机制

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

![gradle执行流程](pic/gradle%E6%89%A7%E8%A1%8C%E6%B5%81%E7%A8%8B.png)



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