package com.fz.testlib;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        test1();

    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int lenght = s[s.length - 1].length();
        System.out.println(lenght);
    }
}
