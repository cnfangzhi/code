文档

https://developer.android.google.cn/studio/build



### android{}

android{}，由AGP引入的节点：

- compileSdkVersion：编译使用版本
- buildToolsVersion：buildTools版本
- defaultConfig：默认产品风味
- productFlavors：自定义产品风味
- buildTypes：构建类型
- compileOptions：编译选项
- signingConfigs：签名设置



### defaultConfig{}

defaultConfig是一种ProductFlavor类型，它是默认的产品风味：

- applicationId：应用唯一的身份识别ID，也是包名
- applicationIdSuffix：buildTools版本
- minSdkVersion：最小支持的sdk版本
- targetSdkVersion：对应项目会运行手机版本内一切特性
- manifestPlaceholders：设置AndroidManifest占位符类型
- flavorDimensions：产品风味选项维度
- versionCode/versionName：工程版本号/工程版本名



### 产品

创建产品变种与创建 build 类型类似：将其添加到构建配置中的productFlavors 代码块并添加所需的设置。产品变种支持与defaultConfig 相同的属性，这是因为，defaultConfig 实际上属于 ProductFlavor类。这意味着，您可以在 defaultConfig代码块中提供所有变种的基本配置，每个变种均可更改其中任何默认值，如 applicationId。

看官方文档：https://developer.android.google.cn/studio/build/build-variants#product-flavors



### BuildType

您可以在模块级 build.gradle文件中的 android 代码块内创建和配置build 类型。当您创建新模块时，Android Studio 会自动为您创建“debug”build类型和“release”build 类型。虽然“debug”build类型没有出现在构建配置文件中，但 Android Studio 会使用 debuggable true 配置它。这样，您就可以在安全的Android 设备上调试应用，并使用常规调试密钥库配置 APK 签名。

如果您要添加或更改某些设置，可以将“debug”build 类型添加到配置中。以下示例为“debug”build 类型指定了 applicationIdSuffix，并配置了一个使用“debug”build 类型的设置进行初始化的“staging”build 类型。



### SigningConfig

设置打包签名相关属性。



### resValue

使用resValue可以为当前的构建产品增加资源文件属性。

resValue'string', 'name', 'value' 

- string表示资源标签的类型。name，资源属性名称。value，对应的属性值。
- 注意，name如果已经存在，就不能进行覆盖。

不同的产品风味都可以添加自己的resValue，如果要所有产品风味都添加到，可以在defalutConfig{}进行添加。



### buildConfigField

使用buildConifgField为产品修改BulidConfig中的类型。

BuildConfig是在产品构建时自动生成的java类，里面存放了一些静态常量，编译后可以直接使用类中的常量。

buildConfigField'String', 'fieldName', 'value'

- String表示字符串类型，可以是其它Java类型，但是要注意，这里做的是文本的替换。所以，如果是其它类型，可以使用全类名的方式。
- filedName表示属性名，value则是对应的值，由于是文本替换，如果value是字符串，需要自己加入双引号。



### sourceSets

在android{}中，可以为构建类型添加SourceSet设置。

sourceSets{}中主要通过main{}来设置源码文件的位置、资源文件存放的位置等。

manifest.srcFile：AndroidManifest文件存放的路径；

java.srcDirs：Java源文件存放的路径；

resources.srcDirs：resources文件(java项目中的) 存放的路径；

aidl.srcDirs：aidl文件存放的路径；

res.srcDirs：res文件夹路径；

assets.srcDirs：assets文件夹路径；

jniLibs.srcDirs：jniLibs文件夹路径；

```
// 每个BuildType都有一个SourceSet
    // 包含源码，源文件等信息
    sourceSets {
        main {
//            manifest.srcFile 'src/main/debug/AndroidManifest.xml'
//            java.srcDirs = ['src']
//            resources.srcDirs = ['src']
//            aidl.srcDirs = ['src']
//            renderscript.srcDirs = ['src']
//            res.srcDirs = ['res']
//            assets.srcDirs = ['assets']
//            jniLibs.srcDirs = ['libs']

            java {
                //exclude 'src/main/com/fz/gradledemo04/Test.java'
//                if(DEBUG){
//
//                }else {
//
//                }
                //srcDir 'src/java'
            }

            /*resources{
                srcDir 'src/java'
            }*/
        }
    }
```



### adbOptions

在android{}中，可以为构建类型添加adb设置。

```
    // adb的操作选项
    adbOptions {
    	timeOutInMs = 5000 // ms
    	
        installOptions '-r', '-s'
        //-l, -t, -d, -g
        // -d 允许降级安装
        // -g 为应有获取所有运行时的权限
        // -l 锁定该应用程序
        // -r 替换已经存在的应用程序，强制安装
        // -t 允许测试包
        // -s 把应用装到sk卡上
    }
```



### javaCompileOptions

使用javaCompileOptions可以在编译时，构建java代码添加一些设置。

比如为apt添加相关的参数：

```
javaCompileOptions {
        annotationProcessorOptions {
            arguments += [A: 'a'] // 注意+= 和 =的区别
        }
    }
```



### 65535方法数限制

DexOpt会把每一个类的方法id检索起来，存在一个链表结构里面。这个链表的长度是用short类型来保存的，这就使得方法数id不能超过65535。

一个dex文件不能超过65535个方法数量，通过打包多个dex文件来解决问题。



### 启用multiDex

1. 在相应的产品风味中设置multiDexEnabledtrue。
2. 添加依赖：implementation'androidx.multidex:multidex:2.0.1'。
3. 创建MyApplication继承MultiDexApplication，并在AndoridManifest指定MyApplication。
4. 如果不方便使用继承MultiDexApplication，可以通过重写Application的attachBaseContext方法，在方法中调用MultiDex.install(this)。



### 什么是aar

- aar就是Android library的二进制归档文件，包含所有资源，class以及res资源文件全部包含。简单来说就是android library工程进行单独打包后的产物。
- 将aar解压（后缀改为.zip，再解压文件）打开后，可以看到每个aar解压后的内容可能不完全一样，但是都会包含AndroidManifest.xml，classes.jar，res，R.txt。

### 如何打包aar

- 先在项目工程中创建library，并且在主工程中依赖这个library。
- 然后在library的任务集中找到assemble这个任务。
- 调用这个assemble任务进行对library打包，会生成对应的aar文件，存放在当前library工程的build/outputs/aar目录下。

### 依赖aar

可以把aar放入到libs文件夹下，然后通过相对路径的方式依赖进来：

- implementation files('libs/xxxxxx.aar')

或者通过添加respositories{flatDir{dirs'libs'}}，然后在进行依赖：

- implementation files(name:'xxxxxx.aar', ext:'aar')

还可以通过把aar发布到maven仓库，然后通过maven来管理这些远程的aar文件，具体依赖就跟使用第三方git上的这些library一样了。



### 注解处理器

annotationProcessor是在依赖管理中通implementation一样重要的设置。

注解处理器主要用来在编译时期，对指定的注解类进行扫描并进行相关的处理。

在dependencies{}中通过annotationProcessor添加进来的library，是不会打包进文件的，而是在编译时期，运行其中的指定的Processor类，这些Processor都继承了AbstractProcessor，并实现其中的process()方法来进行处理注解。



### AbstractProcessor

创建java library并自定义一个Processor来处理注解，一般有如下步骤：

- 继承AbstractProcessor类，重写process和init方法。
- 在类上面使用@AutoService注解，主要作用就是来自动添加main/META-INF/services/javax.annotation.processing.Processor文件的，文件中指定了要使用的Processor类。(使用AutoService)需要annotationProcessor 'com.google.auto.service:auto-service:1.0-rc4' ；compileOnly 'com.google.auto.service:auto-service:1.0-rc4'
- 在类上使用@SupportedAnnotationTypes注解来指定要被扫描处理的注解。(value是注解的全类名，可以添加多个)
- @SupportedSourceVersion(SourceVersion.RELEASE_8)在类上使用，指定支持Java8版本。



### init、process方法

- init方法主要用进行一些初始化的操作，并且可以获取到一些工具类，这些工具类可以用来处理注解使用的类的相关信息，日志，文件处理等等。
- process方法是扫描到注解后主要进入的方法，可以当成注解处理的入口方法。在这个方法中，可以获取到指定注解使用的类的相关信息及注解信息，然后通过Elements各种工具，获取到这个类的所有信息。再配合构建java代码的框架比如javapoet，就可以在编译期间生成自己想要的代码了。



