package com.week3.week3_test.supermarket;

/**
 * @author xz
 * @create 2022-06-21 17:05
 */
public abstract class AbstractTest extends MerchandiseV2 implements Pen {

    private String name;
    private String color;
    private int count;



    public AbstractTest(String name, String id, int count,String color) {
        super(name,id,count);
        this.color = color;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCount(int count) {
        if (count < 0 || count > 5) {
            System.out.println("笔不够"); //默认值
        }else{
            this.count = count;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getCount() {
        return this.count;
    }


    public String toString(){
        return "水彩笔：" + this.getName() + " " + this.getColor() + " " + this.getCount();
    }
}
