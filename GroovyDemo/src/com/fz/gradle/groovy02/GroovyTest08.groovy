package com.fz.gradle.groovy02

class Person5 {
    def username

    // 对不存在的变量进行get操作
    def propertyMissing(String name) {
        println "propertyMissing"
        if (name == 'age') {
            "19" // 返回默认值
        }
    }

    // 对不存在的变量进行set操作
    def propertyMissing(String name, def arg) {
        println "propertyMissing ${name} : arg${arg}"
        return arg// 给与返回值
    }

    def methodMissing(String name, def arg) {
        println "$name methodMissing"
        if (name.startsWith 'getFather') {
            "zzzz"
        }
    }

}

def p = new Person5()
println p.age = 12
println p.age
println p.getFather()

def str = "androidx.appcompat:appcompat:1.1.0"
(group, name, version) = str.split(":")
println group
println name
println version

(p1, p2) = [1, 2]
(p2, p1) = [1, 2]