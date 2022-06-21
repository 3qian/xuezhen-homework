package com.week3.week3_test.supermarket;

import com.week3.week3_94.week3_test1.AbstractTestDateMerchandise;

/**
 * @author xz
 * @create 2022-06-22 0:01
 */
public class Test {
    public static void main(String[] args) {
        WaterColor waterColor = new WaterColor("晨光","001",6,"黑色");
        AbstractTest am = waterColor;

        am.describe();
        System.out.println();
    }
}
