package com.week3.week3_test.supermarket;

/**
 * @author xz
 * @create 2022-06-20 21:41
 */
public class MerchandiseV2 {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public MerchandiseV2() {
        this("无名", "000", 0, 1, 1.1);
    }

    public MerchandiseV2(String name, String id, int count) {
        this.name = name;
        this.id = id;
        this.count = count;
    }

    public MerchandiseV2(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;

    }

    public MerchandiseV2(String name, String id, int count, double soldPrice) {
        this(name, id, count, soldPrice, soldPrice * 0.8);
    }

    public void describe() {
        System.out.println("商品名字叫做" + name + "，id是" + id + "。 数量是" + count);
    }

    // 利润
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
//        if(profit <= 0){
//            return 0;
//        }
        return profit;
    }

    //买几件
    public double buy(int count) {
        if (this.count < count) {
            return -1;
        }
        return this.count -= count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
