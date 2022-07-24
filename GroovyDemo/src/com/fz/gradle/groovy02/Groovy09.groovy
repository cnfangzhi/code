package com.fz.gradle.groovy02

class Man {
    def dream() {
        'I have a dream!'
    }
}

def man = new Man()
def scanner = new Scanner(System.in)
Thread.start {
    println "进入了系统"
    while (true) {
        def msg = scanner.nextLine()
        if (msg == 'exit') {
            println "退出了系统"
            break
        }
        if (man.respondsTo(msg)) {
            println man."${msg}"()
        } else if (msg == 'newDream') {
            man.metaClass."${msg}" {
                println "I have a new dream!"
            }
            man."${msg}"()
        } else {
            println "没有该方法"
        }
    }
}