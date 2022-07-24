package com.fz.kotlinlib.kotlin08

// 扩展函数需要在多个文件里面使用，可以将它定义在单独的文件，然后import
fun <T> Iterable<T>.randomTake(): T = this.shuffled().first()
