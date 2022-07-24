package com.fz.gradle.groovy02

// Groovy动态特性

class User {
    def username = 'zee'
    String age

    void setName(String name) {
        println "setName(String name)"
        this.username = name
    }

    void setName(Object name) {
        println "setName(Object name)"
        this.username = name
    }
}

//def user = new User()
//println user.username.class
//user.username = new Object()
//println user.username.class
//user.username = 123
//println user.username.class
//user.username = new User()
//println user.username.class

//def user = new User()
//Object name = "zee"
//println name.class
//user.setName(name)
//name = 123
//println name.class
//user.setName(name)

def user = new User()
user.age = "123"
user.age = 123
println user.age