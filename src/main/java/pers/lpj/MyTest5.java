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
//        new C();
//        new C();
//
//        System.out.println(MyChild5.b);

        System.out.println(MyParent5_1.THREAD);


    }

}

class MyCrandPa {

    public static Thread THREAD = new Thread() {{

        System.out.println("My MyCrandPa thread ! ");

    }};
}


class MyParent5 extends MyCrandPa {

    public static Thread THREAD = new Thread() {{

        System.out.println("My Parent5 thread5 ! ");

    }};


    /**
     * 接口中的变量都是常量 public static final
     */
    //    public static int a = 10;
//    int a = 10;

}

class MyChild5 extends MyParent5 {

    /**
     * 存在于常量池中
     */
    public static int b = 5;
    /**
     * -----------------------------
     * 但是，如果变量是由复杂运算生成的，
     * 该值会在运行时生成.并不会存在于常量池中
     * -----------------------------
     */
    int c = new Random().nextInt(3);


}

interface MyParent5_1 {
    public static Thread THREAD = new Thread() {{
        System.out.println("My Parent5_1 thread5 ! ");
    }};

}


interface MyCrand5_1 {
    public static Thread THREAD = new Thread() {{
        System.out.println("My Crand5_1 thread5 ! ");
    }};

}



class C {
    static {
        System.out.println(" static block !");

    }


    public C() {
        System.out.println(" class C Constractor!");
    }

    {
        System.out.println("this is only a test!");
    }

}


/**
 * 一个类被初始化，他的所有父类会被初始化，他的父接口除非被主动使用，否者不会被初初始化
 * 一个接口的初始化，不会导致他的父接口的初始化
 * <p>
 * 只有简单的final量才会被直接加载到调用改常量的类中，这意味着，调用类和常量所在的类没有任何关系
 */
