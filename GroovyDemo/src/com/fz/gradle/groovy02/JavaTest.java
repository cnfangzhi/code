package com.fz.gradle.groovy02;

public class JavaTest {

    public static void main(String[] args) {
        double start = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {

        }
        double end = System.nanoTime();
        System.out.println("Java:" + (end - start) / (10000000 * 1000));
        // JAVA:0.002
        // Groovy:0.0087444880
    }

    // Gradle：核心使用Java，脚本使用Groovy开发
}
