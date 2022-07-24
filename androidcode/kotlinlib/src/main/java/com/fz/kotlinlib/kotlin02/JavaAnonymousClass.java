package com.fz.kotlinlib.kotlin02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * @author ningchuanqi
 * @description
 */
public class JavaAnonymousClass {

    public static void main(String[] args) {
        showOnBoard("沐浴露", new DiscountWords() {
            @Override
            public String getDiscountWords(String goodsName, int hour) {
                int currentYear = 2027;
                return String.format("%s年，双11%s促销倒计时：%d 小时",currentYear,goodsName,hour);
            }
        });

        

    }

    public static void showOnBoard(String goodsName,DiscountWords discountWords){
        int hour = new Random().nextInt(24);
        System.out.println(discountWords.getDiscountWords(goodsName,hour));
    }

    public interface DiscountWords{
        String getDiscountWords(String goodsName, int hour);
    }



}
