package com.week3.week3_94.week3_test1;

import com.week3.week3_94.week3_test1.AbstractTestDateMerchandise;


import java.util.Date;


public class Bread extends AbstractTestDateMerchandise  implements ExpireDateMerchandise{

    public Bread(String name, String id, int count, double soldPrice, double purchasePrice, String brand,Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice,brand,produceDate, expirationDate);
    }


}
