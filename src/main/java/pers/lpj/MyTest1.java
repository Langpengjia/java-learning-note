package pers.lpj;

/**
 * @classname: MyTest1
 * @description: 不积跬步，无以至千里
 * @author: Desire
 * @date: 2019-12-20 10:54
 */
public class MyTest1 {

    /**
     * jvm 启动参数设置规则
     * 1. -XX:+<option> 增加一个启动参数
     * 2. -XX:-<option> 移除一个启动参数
     * 3. -XX:<option>=<value> 为一个启动参数赋值
     */
    // -XX:+TraceClassLoading   （将已经初始化话的类的信息在控制台中打印出来）
    public static void main(String[] args) {
        /**
         * 因为child 调用的str 是父类的变量 所以 child类不会初始化 只会初始化 parent
         */
        System.out.println(Child.str);

        /**
         * 因为child 调用 cstr，会对child类完成初始化，其所有的父类和接口都会被初始化 所以Patent 也会完成初始化
         */
//        System.out.println(Child.cstr);

    }

}


class Parent {
    public static String str = " Parent Str !";

    static {
        System.out.println(" Parent static block !  ");
    }
}

class Child extends Parent {

    public  static String cstr = " Child Str !";

    static {
        System.out.println(" Child static block !  ");
    }
}