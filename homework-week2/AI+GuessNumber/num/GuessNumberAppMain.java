package com.geekbang.learn.num;

import java.util.Scanner;

public class GuessNumberAppMain {
    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("还有" + guessNumber.getGuessLeft() + "次机会，请输入猜测的数字，回车确认");
            int input = in.nextInt();
            if (input == -1) {
                guessNumber.endGame();
                break;
            }
            guessNumber.guess(input);
            guessNumber.handelGuessCorrect();
        }
    }
}
