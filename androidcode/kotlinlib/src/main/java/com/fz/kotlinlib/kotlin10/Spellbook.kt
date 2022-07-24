package com.fz.kotlinlib.kotlin10

class Spellbook {
    // 在Java里，不能直接访问spells字段，必须调用spellbook.getSpells，
    // 添加JvmField后，Java可以直接用spellbook.spells调用
    @JvmField
    val spells = listOf("Magic Ms. L", "Lay on Hans")

    companion object{
        // JvmField注解作用伴生对象里定义的值，Java中可以以静态变量方式访问
        @JvmField
        val MAX_SPELL_COUNT = 10
        // JvmStatic 注解，允许Java中直接静态调用
        @JvmStatic
        fun getSpellbookGreeting() = println("I am the Great Grimoire!")
    }

}