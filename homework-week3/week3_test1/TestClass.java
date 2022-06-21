package com.week3.week3_94.week3_test1;


import java.util.Date;


public class TestClass {
    public static void main(String[] args) {
        Date produceDate = new Date();
        Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);
        Bread bread = new Bread(
                "面包001", "面包001", 20, 5, 3,
                "好吃",produceDate, expireDate
        );

        AbstractTestDateMerchandise am = bread;

        am.describe();
        System.out.println();

        System.out.println(am.calculateProfit());

    }
}
