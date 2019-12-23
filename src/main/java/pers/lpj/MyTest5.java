package pers.lpj;

import java.util.Random;

/**
 * @classname: MyTest5
 * @description: 接口和类初始化时的差别
 * @author: Desire
 * @date: 2019-12-23 13:17
 */
public class MyTest5 {


    public static void main(String[] args) {
        /**
         * 当一个接口被初始化时，并不要求其父接口完成初始化
         * 只有真正引用了父接口时，才会初始化父接口
         *
         * 很不好验证
         */
        System.out.println(MyChild5.b);
    }

}


interface MyParent5 {

    /**
     * 接口中的变量都是常量 public static final
     */
//    public static int a = 10;
    int a = 10;

}

interface MyChild5 extends MyParent5 {

    /**
     * 存在于常量池中
     */
    int b = 5;
    /**
     * -----------------------------
     * 但是，如果变量是由复杂运算生成的，
     * 该值会在运行时生成.并不会存在于常量池中
     * -----------------------------
     */
    int c = new Random().nextInt(3);


}