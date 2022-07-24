package com.fz.gradle.groovy

// Groovy中闭包转接口

interface Action2 {
    void aaa()
}
def closure = {
    println "aaa"
}
Action2 action = closure
action.aaa()
println closure.class
println action.class

