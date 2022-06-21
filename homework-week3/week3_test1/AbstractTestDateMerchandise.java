package com.week3.week3_94.week3_test1;

import com.week3.week3_94.week3_test1.ExpireDateMerchandise;
import com.week3.week3_94.week3_test1.MerchandiseV2;

import java.util.Date;


public abstract class AbstractTestDateMerchandise extends MerchandiseV2 implements ExpireDateMerchandise {

    private Date produceDate; // 生产日期
    private Date expirationDate; // 截止日期


    public AbstractTestDateMerchandise(String name, String id, int count, double soldPrice, double purchasePrice, String brand,Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice,brand);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean notExpireInDays(int days) {
        return daysBeforeExpire() > 0;
    }

    private long daysBeforeExpire() {
        long expireMS = expirationDate.getTime();
        long left = expireMS - System.currentTimeMillis();
        if (left < 0) {
            return -1;
        }
        // 返回值是long，是根据left的类型决定的
        return left / (24 * 3600 * 1000);
    }

    private long daysAfterProduce() {
        long produceMS = produceDate.getTime();
        long past = System.currentTimeMillis() - produceMS;
        if (past < 0) {
            // 生产日期是未来的一个时间
            return -1;
        }
        //
        return past / (24 * 3600 * 1000);
    }

    @Override
    public Date getProducedDate() {
        return produceDate;
    }

    @Override
    public Date getExpireDate() {
        return expirationDate;
    }

}
