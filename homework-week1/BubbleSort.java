package com.week1;

/**
 * @author xz
 * @create 2022-06-05 20:30
 * 先把字符串转换为一个的char型数组，接着使用冒泡排序把char型数组的每一个字符转化为int类型然后进行判断。
 */
public class BubbleSort {
    public static void main(String[] args) {
        String str = "jii0e0fjdu9fasd9fwe302/*-d";
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length - 1; i++) {      //长度-1,目的就是为了不会出现数组索引超出的异常
            for (int j = 0; j < c.length - 1; j++) {//
                if ((int) c[j] < (int) c[j + 1]) {//如果相邻的两条数据，前面的比后面的小，就交换顺序。
                    char temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
        }
        System.out.println(c);
    }
}
