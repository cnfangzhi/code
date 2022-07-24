# Kotlin

###### Kotlin 内置数据类型


| 类型    | 描述             | 实例                                       |
| --------- | ------------------ | -------------------------------------------- |
| String  | 字符串           | “Hello World”                            |
| Char    | 单字符           | ‘A'                                       |
| Boolean | true/false       | true false                                 |
| Int     | 整数             | 5                                          |
| Double  | 小数             | 3.14                                       |
| List    | 元素集合         | 1，8，10<br />"Jack", "rose", "jack“      |
| Set     | 无重复元素的集合 | ”Jack", "jason", "jacky"                  |
| Map     | 键值对集合       | “small" to 5, "medium" to 8, "large" to 9 |

###### 查看Kotlin编译之后的字节码

* Shift键两次，输入Show kotlin
* Tools->Kotlin->Show Kotlin Bytecode

###### kotlin01

表达式 Condition.kt

String模板 StringTemplate.kt

函数 Function.kt

###### kotlin02

闭包 Closure.kt

null安全 NullSafe.kt

异常 ExceptionFix.kt

###### kotlin03

字符串操作 StringTest.kt

数字类型 NumberConvert.kt

apply StandardFunctionApply.kt

let StandardFunctionLet.kt

run StandardFunctionRun.kt

with StandardFunctionWith.kt

also StandardFunctionAlso.kt

takeIf takeUnless StandardFunctionTakeIf.kt

###### kotlin04

数组类型 ArrayTypeTest.kt

只读 List Set Map

可变 MutableList MutableSet MutableMap

mutator函数：修改可变列表函数 MutatorFuncTest.kt

集合遍历 ForeachListTest.kt

###### kotlin05

定义类，初始化 Player.kt

继承 Product.kt

对象 ObjectTest.kt

内部类（嵌套类） Player2.kt

###### kotlin06

数据类 运算符重载 Coordinate.kt

**常见操作符**


| 操作符 | 函数名     | 作用                                             |
| -------- | ------------ | -------------------------------------------------- |
| +      | plus       | 一个对象加另一个对象                             |
| +=     | plusAssign | 一个对象加另一个对象，然后把结果赋值给第一个对象 |
| ==     | equals     | 如果两个对象相等，则true，否则false              |
| >      | compareTo  | 左边大于右边，则true，否则false                  |
| []     | get        | 返回集合中指定位置的元素                         |
| ..     | rangeTo    | 创建一个range对象                                |
| in     | contains   | 如果对象包含在集合里，则返回true                 |

枚举类 Direction.kt Direction2.kt LicenseStatus.kt

密封类 LicenseStatus2.kt

###### kotlin07

接口 InterfaceTest.kt

泛型 MagicBox.kt InOutTest.kt

###### kotlin08 扩展函数

kotlin标准库中的扩展通常以类名加s类命名，例如Sequences.kt, Ranges.kt, Maps.kt

kotlin09 函数式编程

1. 变换 transform
   变换函数会遍历集合内容，变换每一个元素，然后返回修改后的元素 集合
   常用变换函数：
   map (FunctionnalMapTest.kt)

   flatMap (FunctionnalFlatMapTest.kt)
2. 过滤 filter
   过滤函数接受一个predicate函数，true就把元素添加到新的集合中常用过滤函数：filter (FunctionnalFilterTest.kt)
3. 合并 combine
   合并函数将不同集合合并成一个新集合，这和接收者是包含集合的集合的flatMap函数不同
   常见合并函数:
   zip, fold (FunctionnalZipAndFoldTest.kt)

及早集合：List、Set、Map

惰性集合（lazy collection）:集合元素按需产生 例如, 序列（Sequence） FunctionnalSequenceTest.kt

###### kotlin10 Kotlin与Java互调用

12131

11
