package com.week3.week3_94.week3_test3;

import com.week3.week3_94.week3_test3.Circle;
import com.week3.week3_94.week3_test3.Football;
import com.week3.week3_94.week3_test3.MyRectangle;

/*
 *
 */
public class GeometricTest {

	public static void main(String[] args) {
		GeometricTest test = new GeometricTest();

		Circle c1 = new Circle(3.3, "white", 1.0);
		test.displayFootball(c1);
		Circle c2 = new Circle(3.3, "white", 1.0);
		test.displayFootball(c2);

		boolean isEquals = test.equalsVolume(c1, c2);
		System.out.println("c1 和 c2的体积是否相等：" + isEquals);


		test.displayFootball1(c1);



    }

    public void displayFootball(Football o){//GeometricObject o = new Circle(...)
        System.out.println("体积为：" + o.findVolume());
    }

    public void displayFootball1(Football o){//GeometricObject o = new Circle(...)
        System.out.println("面积为：" + o.findArea());
    }

	//测试两个对象的体积是否相等
	public boolean equalsVolume(Football o1,Football o2){
		return o1.findVolume() == o2.findVolume();
	}
}
