package pers.lpj;

/**
 * @classname: MyTest5
 * @description:
 * @author: Desire
 * @date: 2019-12-23 13:17
 */
public class MyTest5 {


    public static void main(String[] args) {
        /**
         * 当一个接口被初始化时，并不要求其父接口完成初始化
         * 不好验证
         *
         */
        System.out.println(MyChild5.b);
    }

}


interface MyParent5 {

    /**
     * 接口中的变量都是常量
     */
//    public static int a = 10;
    int a = 10;

}

interface MyChild5 extends MyParent5 {

    int b = 5;
}