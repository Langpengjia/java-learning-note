package pers.lpj;

/**
 * @classname: MyTest8
 * @description:
 * @author: Desire
 * @date: 2019-12-24 13:18
 */

/**
 * 在初始化阶段
 * 先被类加载器加载的类先被初始化
 */
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(MyChild8.b);
    }

}

class MyParent8 {

    static int a = 10;

    static {
        System.out.println("this is a parent8 block ! ");
    }

    public static void main(String[] args) {

        System.out.println(MyChild8.b);
    }

}

class MyChild8 extends MyParent8{
    static int b = 20;

    static {
        System.out.println("this is a child8 block ! ");
    }


}
