package com.geekbang.learn.num;

public class GuessNumber {
    private static final int rangeStart = 30;
    private static final int rangeEnd = 50;
    private static final int guessTotal = 5;
    private int guessLeft = 0;
    private boolean gameStart = false;
    private boolean guessCorrect = false;//是否猜中
    private int guessNumber = 0;
    private int totalGameCount = 0;//
    private int totalCorrectCount = 0;//猜对次数

    public GuessNumber() {
        totalGameCount = 0;
        totalCorrectCount = 0;
        initGame();
    }

    private void initGame() {
        guessLeft = guessTotal;
        // 生成随机数过程
        int mod = rangeEnd - rangeStart;
        double randNum = Math.random();//生成一个0到1之间的随机数
        int num = ((int) (randNum * rangeEnd * 100)) % mod;//生成了一个0到20之间的随机数
        guessNumber = num + rangeStart;//随机数范围在30到50之间
        gameStart = true;
        guessCorrect = false;
        System.out.println("=================== 猜 数 字 ===================");
        System.out.println("随机数已经生成，范围为" + rangeStart + "~" + rangeEnd + "，" +
                "不包括这两个数。共有" + guessTotal + "次猜测的机会。输入-1随时结束游戏。");
    }
    /**
     * 猜数字方法
     * @param guessNumIn 键盘输入值
     * @return
     */
    public void guess(int guessNumIn) {
        if (guessNumIn <= rangeStart || guessNumIn >= rangeEnd) {
            System.out.println("请输入在" + rangeStart + "到" + rangeEnd + "之间，的数字，不包括这两个数。");
            return;
        }

        // 只要至少猜过一次，就算玩过了。
        if (gameStart) {
            totalGameCount++;
            gameStart = false;
        }
        // 可以用的猜测次数减1
        guessLeft--;
        if (guessNumIn == guessNumber) {
            totalCorrectCount++;
            guessCorrect = true;
            System.out.println("输入的数字正确，答案为：" + guessNumber +
                    "。本次你共猜了" + (guessTotal - guessLeft) + "次。");
            initGame();
            return;
        } else if (guessNumIn > guessNumber) {
            System.out.println("输入的数字比目标数字大。");
        } else {
            System.out.println("输入的数字比目标数字小。");
        }
    }

    public void handelGuessCorrect() {
        if(guessLeft <= 0 && !guessCorrect) {
            System.out.println("本次的目标数字是" + guessNumber + "。这次没有猜中。");
            initGame();
        }
    }

    public void endGame() {
        System.out.println("共进行了" + totalGameCount + "次游戏，正确次数为" + totalCorrectCount + "次");
    }

    public int getGuessLeft() {
        return guessLeft;
    }
}
