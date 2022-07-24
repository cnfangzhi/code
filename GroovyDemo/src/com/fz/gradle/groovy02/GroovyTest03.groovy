package com.fz.gradle.groovy02

import groovy.transform.CompileStatic

@CompileStatic
class Test2 {

    public static void main(String[] args) {
        def start = System.nanoTime()
        for (int i = 0; i < 10000000; i++) {
        }
        def end = System.nanoTime()
        println("Groovy:" + (end - start) / (10000000 * 1000))
        //Groovy:0.0059393699
        //Groovy:0.0091492210
        //Groovy:0.0043080980
        // JAVA:0.002
    }

}