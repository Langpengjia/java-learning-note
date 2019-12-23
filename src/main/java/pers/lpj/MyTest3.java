package pers.lpj;

import java.util.UUID;

/**
 * @classname: MyTest3
 * @description:
 * @author: Desire
 * @date: 2019-12-20 14:39
 */
public class MyTest3 {

    public static void main(String[] args) {
        System.out.println(MyParent3.b);
    }

}

class  MyParent3{

    /**
     * MyParent3不会初始化
     */
    public static final int a = 3;
    /**
     * MyParent3不会初始化
     */
    public static final int b = a+3;

    /**
     * MyParent3会初始化
     * 当常量的值事由复杂计算的结果产生时，无法在编译阶段存入调用该常量的方法所在的类的常量池中，
     * 需要在初始化阶段有常量所在的类主动调用产生，所以，该常量所在的类会被初始化
     */
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println(" myparent3 block ");
    }



}
