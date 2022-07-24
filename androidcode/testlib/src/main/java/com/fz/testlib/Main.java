package com.fz.testlib;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine().toLowerCase();
        String s = sc.nextLine();
        System.out.print(str.length()-str.replaceAll(s,"").length());
    }

}
