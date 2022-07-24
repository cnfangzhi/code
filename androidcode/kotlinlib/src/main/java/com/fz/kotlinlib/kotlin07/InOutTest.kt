package com.fz.kotlinlib.kotlin07
//out 泛型只作为函数的返回（输出）
interface Production<out T> {
    fun product(): T
}

//in 泛型只作为函数的入参（输入）
interface Consumer<in T> {
    fun consume(item: T)
}

//不变
interface ProductionConsumer<T> {
    fun product(): T
    fun consume(item: T)
}

open class Food
open class FastFood : Food()
class Burger : FastFood()

//生产者
//食品商店
class FoodStore : Production<Food>{
    override fun product(): Food {
        println("Produce food.")
        return Food()
    }
}
//快餐商店
class FastFoodStore : Production<FastFood>{
    override fun product(): FastFood {
        println("Produce FastFood.")
        return FastFood()
    }
}

//汉堡商店
class BurgerStore : Production<Burger>{
    override fun product(): Burger {
        println("Produce Burger.")
        return Burger()
    }
}

//消费者
class Everybody : Consumer<Food>{
    override fun consume(item: Food) {
        println("Eat food.")
    }
}

class ModernPeople : Consumer<FastFood>{
    override fun consume(item: FastFood) {
        println("Eat fastFood.")
    }
}

class American : Consumer<Burger>{
    override fun consume(item: Burger) {
        println("Eat burger.")
    }
}


fun main() {
    //赋值
    //子类泛型对象可以赋值给父类泛型对象，用 out。
    val production1: Production<Food> = FoodStore()
    val production2: Production<Food> = FastFoodStore()
    val production3: Production<Food> = BurgerStore()

    //父类泛型对象可以赋值给子类泛型对象，用 in。
    val consumer1: Consumer<Burger> = Everybody()
    val consumer2: Consumer<Burger> = ModernPeople()
    val consumer3: Consumer<Burger> = American()
}