package com.geekbang;

import com.geekbang.person.Customer;
import com.geekbang.supermarket.LittleSupermarket;
import com.geekbang.supermarket.Merchandise;

import java.util.Scanner;

/**
 * @author xz
 * @create 2022-06-06 14:28
 */
public class RunLittleSupermarketAppMain {
    public static void main(String[] args) {
        //创建小超市类
        LittleSupermarket littleSupermarket = new LittleSupermarket();
        littleSupermarket.address = "宁波";
        littleSupermarket.superMarketName = "宁大超市";
        littleSupermarket.parkingCount = 200;
        littleSupermarket.merchandises = new Merchandise[200]; // 200种商品
        littleSupermarket.merchandiseSold = new int[littleSupermarket.merchandises.length];

        Merchandise[] all = littleSupermarket.merchandises;
        for (int i = 0; i < all.length; i++) { // 给200种商品赋值
            Merchandise m = new Merchandise();
            m.count = 200; //属性赋值
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.purchasePrice = Math.random() * 200; //商品价格0~200之间
            m.soldPrice = (1 + Math.random()) * 200;
            all[i] = m;

        }
        System.out.println("开业大吉");

        boolean open = true;
        Scanner scanner = new Scanner(System.in);
        while (open){
            System.out.println("本店叫做" + littleSupermarket.superMarketName);
            System.out.println("地址在" + littleSupermarket.address);
            System.out.println("共有停车位" + littleSupermarket.parkingCount + "个");
            System.out.println("今天的营业额为" + littleSupermarket.incomingSum);
            System.out.println("共有商品" + littleSupermarket.merchandises.length + "种");

            // 创建顾客
            Customer customer = new Customer();
            customer.name = " 顾客编号" + ((int)(Math.random() * 10000));
            customer.money = (1+ Math.random()) * 1000;
            customer.isDrivingCar = Math.random() > 0.5;

            //判断车位够不够
            if (customer.isDrivingCar){
                if (littleSupermarket.parkingCount > 0){
                    littleSupermarket.parkingCount--;
                    System.out.println("欢迎" + customer.name + "驾车而来，车位编号为" + littleSupermarket.parkingCount);
                }else{
                    System.out.println("车位满了，下次再来");
                    continue;
                }
            }else{
                System.out.println("欢迎"+customer.name + "光临");
            }

            //商品选购
            double totalCost = 0;
            while (true){
                System.out.println("本店提供" + all.length + "种商品，请输入商品编号：");
                int index = scanner.nextInt();

                if (index < 0) {
                    break;
                }
                if (index >= all.length){
                    System.out.println("本店没有这种商品，请输入编号在0到" + (all.length-1) + "之内的编号");
                    continue;
                }

                Merchandise m = all[index]; // 取出商品

                System.out.println("选购的商品名字" + m.name + "。单价是" + m.soldPrice + "。要几个？");
                int numToBuy = scanner.nextInt();

                // 不想买，看看
                if (numToBuy <= 0) {
                    System.out.println("不买看看");
                    continue;
                }
                // 买的太多，库存不够
                if (m.count < numToBuy) {
                    System.out.println("库存不够，不好意思。");
                    continue;
                }
                // 顾客钱不够
                if (numToBuy * m.purchasePrice + totalCost > customer.money) {
                    System.out.println("您带的钱不够。");
                    continue;
                }

                totalCost += numToBuy * m.soldPrice; // 数量*单价

                m.count -= numToBuy;
                littleSupermarket.merchandiseSold[index] += numToBuy; // 记录卖了几个
            }
            customer.money -= totalCost;

            if (customer.isDrivingCar){
                littleSupermarket.parkingCount++; //车位再加上去
            }

            System.out.println(customer.name + "共消费" + totalCost);

            littleSupermarket.incomingSum += totalCost; //赚的钱

            System.out.println("还营业吗");
            open = scanner.nextBoolean();
            System.out.println("今日销售额为" + littleSupermarket.incomingSum + "。营业统计如下：");

            for (int i = 0; i < littleSupermarket.merchandiseSold.length; i++) {
                Merchandise m = all[i];
                int numSold = littleSupermarket.merchandiseSold[i];
                if (numSold > 0) {

                    double incoming = numSold * m.soldPrice; //卖的钱
                    double netIncoming = numSold * (m.soldPrice - m.purchasePrice); //减去成本赚的钱

                    System.out.println(littleSupermarket.merchandises[i].name + "售出" + numSold + "个。销售额" + incoming + "。净利润" + netIncoming);
                }
            }
        }
    }
}
