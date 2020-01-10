package pers.lpj;

/**
 * @classname: MyTest2
 * @description:
 * @author: Desire
 * @date: 2019-12-20 13:21
 */
public class MyTest2 {

    public static void main(String[] args) {

        /**
         *
         *  ldc : 将类型为 int float或 String 的常量从常量池中推入栈顶
         *  bipush :将单字节的（-128~127）的值 推入栈顶
         *  sipush :将短整型常量（-32768~32767）的值 推入栈顶
         *
         */
//        System.out.println(Parent2.str);



        System.out.println(Parent2.a);
    }

}

class Parent2 {


    /**
     * final 常量 在编译阶段 会被 存入 调用改常量的方法所在的类(MyTest2)的常量池中,
     * <MyTest2 和 Parent2 没有任何关系！>
     * 本质上 调用类 并没有直接引用到定义常量的类，所以不会触发定义常量的类的初始化
     */
    public static final String str = " hello world！";

    public static final int a = 127;


//    public static String str = " hellp world！";


    static {
        System.out.println("parent2 static block");
    }


}