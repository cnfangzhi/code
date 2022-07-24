package com.fz.kotlinlib.kotlin07

class MagicBox<T>(item: T) {
    var available = false
    private var subject: T = item

    fun fetch():T?{
        return subject.takeIf { available }
    }

    fun <R> fetch(subjectModFunction: (T) -> R): R? {
        return subjectModFunction(subject).takeIf { available }
    }
}

class MagicBox2<T : Human>(item: T) {
    var available = false
    private var subject: T = item

    fun fetch(): T? {
        return subject.takeIf { available }
    }

    //业务，把元素进行修改
    //魔盒里面放的是男孩，取出来的时候，我给他改成了一个男人
    //return -> R
    fun <R> fetch(subjectModFunction: (T) -> R): R? {
        return subjectModFunction(subject).takeIf { available }
    }

}

// vararg 可以传多个实例
class MagicBox3<T : Human>(vararg item: T) {
    var available = false
    private var subject: Array<out T> = item

    fun fetch(index: Int): T? {
        return subject[index].takeIf { available }
    }

    //业务，把元素进行修改
    //魔盒里面放的是男孩，取出来的时候，我给他改成了一个男人
    //return -> R
    fun <R> fetch(index: Int, subjectModFunction: (T) -> R): R? {
        return subjectModFunction(subject[index]).takeIf { available }
    }

    // [] 重载
    operator fun get(index: Int): T? = subject[index]?.takeIf { available }

    // reified 关键字能帮你检查泛型参数类型
    inline fun <reified T> randomOrBackup(backup: () -> T): T {
        val items = listOf(
                Boy("Jack", 20),
                Man("John", 35)
        )
        val random = items.shuffled().first()
        println(random)
        return if(random is T){
            random
        }else{
            backup()
        }
    }
}

open class Human(val age: Int)
class Boy(val name: String, age: Int) : Human(age){
    override fun toString(): String {
        return "Boy(name='$name',age='$age')"
    }
}
class Man(val name: String, age: Int) : Human(age){
    override fun toString(): String {
        return "Man(name='$name',age='$age')"
    }
}

class Dog(val weight: Int)

fun main() {
    val box1:MagicBox<Boy> = MagicBox(Boy("Jack",20))

    box1.fetch()?.run {
        println("you find $name")
    }

    val box2: MagicBox2<Boy> = MagicBox2(Boy("Jack", 15))
    box2.available = true

    box2.fetch()?.run {
        println("you find $name")
    }

    val man2 = box2.fetch {
        Man(it.name, it.age.plus(15))
    }

    val box3: MagicBox3<Boy> = MagicBox3(
            Boy("Jack", 15),
            Boy("Jacky", 16),
            Boy("John", 26)
    )
    box3.available = true

    box3.fetch(1)?.run {
        println("you find $name")
    }

    val man3 = box3.fetch(2) {
        Man(it.name, it.age.plus(15))
    }

    val box4: MagicBox3<Boy> = MagicBox3(
            Boy("Jack", 15),
            Boy("Jacky", 16),
            Boy("John", 26)
    )
    box4.available = true

    box4.fetch(1)?.run {
        println("you find $name")
    }

    val man4 = box4.fetch(2) {
        Man(it.name, it.age.plus(15))
    }

    box4[0]

    val box5:MagicBox3<Boy> = MagicBox3()
    //又backup函数，推断出来T的类型
    val subject = box5.randomOrBackup {
        Boy("Jimmy", 38)
    }
    println(subject)
}
