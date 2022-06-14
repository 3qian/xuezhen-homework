package com.adv.supermarket;

/**
 * @author xz
 * @create 2022-06-06 20:31
 */
public class MerchandiseV2 {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;


    public void describe() {   // 中间可以放参数
        double netIncome = soldPrice - purchasePrice; //局部变量
        System.out.println("商品名：" + name + "，id：" + id + "。 商品售价：" + soldPrice
                + "。商品进价：" + purchasePrice + "。商品库存量：" + count +
                "。销售一个的利润：" + netIncome);
    }

    public double calculateProfit(){ // 有返回值，return关键字  不需要返回值选择void
        double profit = soldPrice - purchasePrice;
        if (profit <= 0) {
            return 0; //最后一句
        }
        //
        return profit;

    }

    // 返回值是负数，购买失败，库存不足
    public double buy(int countToBuy) { // 形参
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            return -1;
        }

        System.out.println("商品单价为" + soldPrice);

        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        count -= countToBuy;

        return totalCost;
    }

    // 一个方法可以有多个参数，多个参数之间用逗号隔开
    public double buyAndPrintLeft(int countToBuy, boolean printLeft) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            if (printLeft) {
                System.out.println("商品剩余库存为" + count);
            }
            return -1;
        }

        //
        System.out.println("商品单价为" + soldPrice);

        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        count -= countToBuy;

        if (printLeft) {
            System.out.println("商品剩余库存为：" + count);
        }

        return totalCost;
    }

    // 参数可以是任何类型
    public boolean totalValueBiggerThan(MerchandiseV2 merchandiseV2) {
        return count * purchasePrice > merchandiseV2.purchasePrice * merchandiseV2.count;
    }

    // 参数可以是任何类型，包括自定义类型
    public boolean isTheBiggestTotalValueOne(LittleSuperMarket littleSuperMarket) {
        double totalValue = count * purchasePrice;
        for (int i = 0; i < littleSuperMarket.merchandises.length; i++) {
            MerchandiseV2 m = littleSuperMarket.merchandises[i];
            double newTotalValue = m.count * m.purchasePrice;
            if (totalValue < newTotalValue) {
                // 执行到return的时候，方法直接结束，不管是不是在循环中，是在第几层循环中。
                return false;
            }
        }
        return true;
    }

    public double getCurrentCount(){
        return count;
    }

    public int getIntSoldPrice(){
        return (int) soldPrice; //不符合，强转
    }

}
