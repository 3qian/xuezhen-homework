package com.geekbang.learn.num;

import java.util.Scanner;

/**
 * @author xz
 * @create 2022-06-05 17:58
 */
public class aaa {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // 游戏设置
        int rangeStart = 30;
        int rangeEnd = 50;
        int guessTotal = 5;

        int totalGameCount = 0;//
        int totalCorrectCount = 0;//猜对次数

        // 设置一个flag，方便后续循环与跳出循环
        boolean stopGame = false;

        while (!stopGame) {
            // 生成随机数过程
            int guessLeft = guessTotal;
            int mod = rangeEnd - rangeStart;
            double randNum = Math.random();//生成一个0到1之间的随机数
            int num = ((int) (randNum * rangeEnd * 100)) % mod;//生成了一个0到20之间的随机数
            num += rangeStart;//随机数范围在30到50之间

            //确保随机数在范围内
//            if (num <= rangeStart) {
//                num = rangeStart + 1;
//            }
//            if (num >= rangeEnd) {
//                num = rangeEnd - 1;
//            }


            System.out.println("=================== 猜 数 字 ===================");
            System.out.println("随机数已经生成，范围为" + rangeStart + "~" + rangeEnd + "，" +
                    "不包括这两个数。共有" + guessTotal + "次猜测的机会。输入-1随时结束游戏。");

            // 游戏开始
            boolean gameStart = true;
            // 是否猜中数字
            boolean guessCorrect = false; //是否猜中

            while (guessLeft > 0) {
                System.out.println("还有" + guessLeft + "次机会，请输入猜测的数字，回车确认");
                int guessNum = in.nextInt();
                // 输入-1，结束游戏
                if (guessNum == -1) {
                    stopGame = true;
                    break;
                }

                if (guessNum <= rangeStart || guessNum >= rangeEnd) {
                    System.out.println("请输入在" + rangeStart + "到" + rangeEnd + "之间，的数字，不包括这两个数。");
                    continue;
                }
                // 只要至少猜过一次，就算玩过了。
                if (gameStart) {
                    totalGameCount++;
                    gameStart = false;
                }
                // 可以用的猜测次数减1
                guessLeft--;
                if (guessNum == num) {
                    totalCorrectCount++;
                    guessCorrect = true;
                    System.out.println("输入的数字正确，答案为：" + num +
                            "。本次你共猜了" + (guessTotal - guessLeft) + "次。");
                    break;
                } else if (guessNum > num) {
                    System.out.println("输入的数字比目标数字大。");
                } else {
                    System.out.println("输入的数字比目标数字小。");
                }
            }

            if (!guessCorrect) {
                System.out.println("本次的目标数字是" + num + "。这次没有猜中。");
            }
        }

        System.out.println("共进行了" + totalGameCount + "次游戏，正确次数为" + totalCorrectCount + "次");
    }
}
