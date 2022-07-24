### 数据类型

基本数据类型：
byte、short、int、long、float、double、char、boolean

包装类 (装箱拆箱)：
String、Byte、Short、Integer、Long、Float、Double、Char、Boolean

### 字符串

单引号字符串是java.lang.String类型，同时不支持插值。

双引号字符串在没有使用插值表达式情况下是java.lang.String类型， 但如果有插值表达式使用的话，就是groovy.lang.GString类型。

三引号字符串表示多行的字符串。不必将字符串分割成几块，也不必用连接符或换行符转义字符来将字符串跨行。

**字符串的使用：**

单引号单个字符要表示char类型，需要使用as转换。

${..} 表达式进行插值，去掉花括号不引起歧义的话，可以去掉。

**可以通过+=, -=操作符添加/减少字符 (会自动匹配)。**

### 定义变量-动态类型
使用def关键字定义变量，不过已使用了final (不可变), priviate这样修饰符，def可以省略。

### 数组和列表
数组和列表都是使用逗号分割列表的值，使用方括号括起来表示。

Groovy中的数组和列可以随意转换。

def定义的变量会自动推断 [ ] 类型是列表。

Groovy列表是普通的JDK java.util.List，因为Groovy中没有定义自己的集合类。

### 范围
范围是一种特殊的列表，由序列中的第一个和最后一个值表示，Range可以是包含或排除。包含范围包括从第一个到最后一个的所有值，而独占范围包括除最后一个之外的所有值。也可以使用表达式来表示范围，例如：

1..10  包含范围的示例；

1..<10  独占范围的示例 (开区间)；

'a'..'x'  范围也可以由字符组成；

10..1  范围也可以按降序排列；

'x'..'a'  范围也可以由字符组成并按降序排列。同步请求/异步请求实现。

### 映射
映射（也称为关联数组，字典，表和散列）是对象引用的无序集合。Map集合中的元素由键值访问。Map中使用的键可以是任何类，如果不能推断具体key类型，默认就是字符串。

在Groovy中可以使用特定的表述方式来指定映射：

[k1：v1，k2：v2]  具有键值对的集合。

[:] 空映射。

## Groovy类与方法
### getter/setter
默认会生成getter, setter方法：

并且可以直接像使用成员变量的方法来自动判断调用getter/setter。

当进行赋值时调用setter方法，

当直接访问值时调用的是getter方法。

使用'.@'才是真正的直接访问变量，跳过默认的getter/setter方法调用。


### Groovy中private不被限制

所有的变量默认是public的。

如果要设置为私有禁止直接访问，仅申明private是不行的。依然可以使用'.'直接访问。

即使把这段代码放入到另外一个package下面也不行。

重载这个变量的getter/setter方法，并且在调用方法时抛出异常

Java中如果没有显式的指定访问修饰符（public、protected、private）那么默认是包访问权限，Groovy使用@PackageScope

### 构造方法
构造方法重载规则跟Java一样。

但是要注意，如果没有指定具体参数的类型时，默认推断类型是Object。

在构造方法中传入具名参数，但是要注意：传入的参数都是键值对，实则就是一个Map类型！

这种方式传入的参数会自动拆解Map并且调用setter方法对应的进行赋值。

如果参数中还有非键值对的传参，就会把这些键值对当成Map了不会再进行自动拆解赋值。所以要有对应的构造方法才行。



### 操作符重载
重写每个操作符对应的方法可以实现操作符重载。



| 操作符                 | 方法                               |
| ---------------------- | ---------------------------------- |
| a + b                  | a.plus(b)                          |
| a - b                  | a.minus(b)                         |
| a * b                  | a.multiply(b)                      |
| a ** b                 | a.power(b)                         |
| a / b                  | a.div(b)                           |
| a % b                  | a.mod(b)                           |
| a \| b                 | a.or(b)                            |
| a & b                  | a.and(b)                           |
| a ^ b                  | a.xor(b)                           |
| a++ or ++a             | a.next                             |
| a-- or --a             | a.previous()                       |
| a[b]                   | a.getAt(b)                         |
| a[b] = c               | a.putAt(b, c)                      |
| a << b                 | a.leftShift(b)                     |
| a >> b                 | a.rightShift(b)                    |
| ~a                     | a.bitwiseNegate()                  |
| -a                     | a.negative()                       |
| switch(a) {case(b) : } | b.isCase(a)                        |
| a == b                 | a.equals(b) or a.compareTo(b) == 0 |
| a != b                 | !a.equals(b)                       |
| a <=> b                | a.compareTo(b)                     |
| a > b                  | a.compareTo(b) > 0                 |
| a >= b                 | a.compareTo(b) >= 0                |

### Groovy的动态特性

- 使用def定义变量，类型由运行时对其赋值的类型类确定。

- Java中要使用继承才能实现多态，而Groovy轻而易举。

  优势：使用时非常灵活！

  缺点：编译时不会检查类型，运行时报错，需要更加注重细节。

- 可以使用MOP进行元编程。

### 元编程

- Java中可以通过反射，在运行时动态的获取类的属性，方法等信息，然后反射调用。但是没法直接做到往内中添加属性、方法和行为。( 需要通过动态字节码技术如ASM、javassist等技术来实现动态的修改class )
- MOP (元对象协议)：Meta Object Protocol
- Groovy直接可以使用MOP进行元编程，我们可以基于应用当前的状态，动态的添加或者改变类的方法和行为。比如在某个Groovy类中并没有实现某个方法，这个方法的具体操作由服务器来控制，使用元编程，为这个类动态添加方法，或者替换原来的实现，然后可以进行调用。

### MOP方法拦截

- 实现GroovyInterceptable接口，重写invokeMethod来进行拦截。

- 使用MetaClass拦截方法，覆盖invokeMethod方法。

  使用类的MetaClass，针对的是class对象，所有实例都会被影响。

  使用具体实例的MetaClass，只影响当前对象实例。



### MOP方法注入

方法注入：编写代码时知道想要添加到一个或多个类中的方法的名字。利用方法注入，可以动态地向类中添加行为。也可以向任意数目的类中注入一组实现某一特定功能的可服用方法，就像工具函数。有以下几种方式：

- 使用分类注入方法。

- 使用ExpandoMetaClass注入方法。

  直接使用类或实例的MetaClass注入方法，实际上最终操作的类型是ExpandoMetaClass。

  手动创建ExpandoMetaClass来进行注入。


- 使用Mixin注入方法。( 在类中可以使用多个Mixin )



### MOP方法合成

方法合成：想在调用时动态地确定方法的行为。Groovy的invokeMethod()、methodMissing()和GroovyInterceptable对于方法合成非常有用。

- 使用methodMissing()合成方法。
- 使用ExpandoMetaClass合成方法。



### MOP方法委托

使用Expando动态生成动态类。

使用methodMissing实现方法委托。