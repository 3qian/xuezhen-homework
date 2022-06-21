package com.week3.week3_94.week3_test1;

import java.util.Date;


public interface ExpireDateMerchandise {

    
    /**
     * 截止到当前，商品的保质期天数是否超过传递的天数
     *
     * @param days 截止到当前，保质期超过这么多天
     * @return 截止到当前，true如果保质期剩余天数比参数长，false如果保质期不到这多天
     */
    boolean notExpireInDays(int days);

    // >> TODO 因为接口里的方法都是且只能用public abstract修饰，所以这俩修饰符可以省略

    /**
     * @return 商品生产日期
     */
    Date getProducedDate();

    /**
     * @return 商品保质期到期日
     */
    public abstract Date getExpireDate();



}
