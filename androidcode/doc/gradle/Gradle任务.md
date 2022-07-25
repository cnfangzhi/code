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

## 